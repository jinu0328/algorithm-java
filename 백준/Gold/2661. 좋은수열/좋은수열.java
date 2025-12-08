import java.util.Scanner;

public class Main {
    static int n;
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = new int[n];

        solve(0);
    }

    private static boolean solve(int endIndex) {
        // base
        if(endIndex == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i]);
            }
            return true;
        } else {
            for(int i = 1; i <=3; i++) {
                numbers[endIndex] = i;
                if(!isBad(endIndex)) {
                    if(solve(endIndex + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isBad(int endIndex) {
        for(int i = 1; i <= (endIndex + 1) / 2; i++) {
            boolean isSame = true;
            for(int j = 0; j < i; j++) {
                if(numbers[endIndex - j] != numbers[endIndex - j - i]) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) {
                return true;
            }
        }
        return false;
    }
}
