import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static int C;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        x = new int[N];
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        int min = x[0];
        int max = x[x.length - 1];

        int low = 1;
        int high = max - min;

        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(isPossible(x, mid, C)) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isPossible(int[] x, int mid, int c) {
        int count = 1;
        int lastPosition = x[0];
        for(int i = 1; i < x.length; i++) {
            if(x[i] - lastPosition >= mid) {
                count++;
                lastPosition = x[i];
            }
        }
        return count >= c;
    }

}
