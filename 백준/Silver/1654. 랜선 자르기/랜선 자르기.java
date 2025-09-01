import java.io.*;
import java.util.*;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());

        long[] lanes = new long[K];

        long high = 0;
        for(int i = 0; i < K; i++) {
            lanes[i] = Long.parseLong(br.readLine());
            if(lanes[i] > high) high = lanes[i];
        }

        long low = 1;
        long result = 0;

        while(low <= high) {
            long mid = (low + high) / 2;

            if(getCount(lanes, mid) < N) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long getCount(long[] lanes, long mid) {
        long count = 0;
        for(long len : lanes) {
            count += len / mid;
        }
        return count;
    }
}
