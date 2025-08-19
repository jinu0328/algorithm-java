import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        int[] kan = new int[N + 1];

        String[] input2 = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            kan[i] = Integer.parseInt(input2[i - 1]);
        }

        int[] job = new int[N + 2];
        while(M-- > 0) {
            String[] input3 = br.readLine().split(" ");
            int a = Integer.parseInt(input3[0]);
            int b = Integer.parseInt(input3[1]);
            int k = Integer.parseInt(input3[2]);

            job[a] += k;
            job[b + 1] += -k;
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += job[i];
            bw.write((sum + kan[i]) + " ");
        }
        bw.flush();
    }
}