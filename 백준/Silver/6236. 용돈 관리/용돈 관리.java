import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[] costs = new int[N];
        for(int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
        }

        int low = 0;
        int high = 0;

        for(int cost : costs) {
            high += cost;
            low = Math.max(low, cost);
        }


        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(getCount(costs, mid) > M) {
                low = mid + 1;
            }
            else {
                result = mid;
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static int getCount(int[] costs, int mid) {
        int count = 0;
        int current = 0;
        for(int i = 0; i < N; i++) {
            if(costs[i] > current) {
                current = mid - costs[i];
                count++;
            }
            else {
                current -= costs[i];
            }
        }

        return count;
    }
}
