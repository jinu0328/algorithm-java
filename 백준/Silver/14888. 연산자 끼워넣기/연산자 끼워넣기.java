import java.util.Scanner;

public class Main {
    static int n;
    static int[] nums;
    static int[] operation = new int[4];
    static int ADD = 0;
    static int DISTRACT = 1;
    static int MULTIPLE = 2;
    static int DIVIDE = 3;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
           operation[i] = sc.nextInt();
        }

        solve(1, nums[0], new int[4]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int index, int value, int[] op) {
        if(index == n) {
            if(op[ADD] == operation[ADD] && op[DISTRACT] == operation[DISTRACT] &&
                    op[MULTIPLE] == operation[MULTIPLE] && op[DIVIDE] == operation[DIVIDE]
            ) {
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
            return;
        }

        op[ADD]++;
        solve(index + 1, value + nums[index], op);
        op[ADD]--;

        op[DISTRACT]++;
        solve(index + 1, value - nums[index], op);
        op[DISTRACT]--;

        op[MULTIPLE]++;
        solve(index + 1, value * nums[index], op);
        op[MULTIPLE]--;

        op[DIVIDE]++;
        solve(index + 1, value / nums[index], op);
        op[DIVIDE]--;
    }
}