import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        int i = 0;
        int j = 0;

        Arrays.sort(A);

        int result = Integer.MAX_VALUE;
        while(j < N && i < N) {
            int diff = Math.abs(A[i] - A[j]);
            if(diff > M) {
                result = Math.min(result, diff);
                i++;
            }
            else if(diff == M) {
                result = Math.min(result, diff);
                i++; j++;
            }
            else {
                j++;
            }
        }

        System.out.println(result);
    }
}
