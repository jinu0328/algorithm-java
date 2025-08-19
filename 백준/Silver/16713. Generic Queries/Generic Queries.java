import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        int[] arr = new int[N + 1];
        String[] input2 = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input2[i - 1]);
        }

        int[] acc = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }

        int result = 0;
        while(Q-- > 0) {
            String[] input3 = br.readLine().split(" ");
            int s = Integer.parseInt(input3[0]);
            int e = Integer.parseInt(input3[1]);

            result ^= acc[s- 1] ^ acc[e];
        }

        System.out.println(result);
    }
}