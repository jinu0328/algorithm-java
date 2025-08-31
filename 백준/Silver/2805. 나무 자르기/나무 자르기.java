import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] tree = new int[N];
        for(int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }
        int result = 0;

        Arrays.sort(tree);

        int low = 0;
        int high = tree[tree.length - 1];

        while(low <= high) {
            int mid = (low + high) / 2;
            long remain = getRemain(tree, mid);

            if(remain < M) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
                result = Math.max(mid, result);
            }
        }

        System.out.println(result);

    }

    private static long getRemain(int[] tree, int mid) {
        long remain = 0;

        for(int num : tree) {
            remain += Math.max(0, num - mid);
        }

        return remain;
    }
}
