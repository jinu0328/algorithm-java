import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        A = new int[N];
        B = new int[M];

        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input2[i]);
        }

        String[] input3 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(input3[i]);
        }

        int[] result = new int[N + M];

        for(int i = 0; i < N; i++) {
            result[i] = A[i];
        }

        for(int i = N; i < N + M; i++) {
            result[i] = B[i - N];
        }

        Arrays.sort(result);

        for(int num : result) {
            bw.write(num + " ");
        }

        bw.flush();
    }
}
