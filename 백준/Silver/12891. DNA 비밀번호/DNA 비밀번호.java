import java.io.*;
import java.util.*;

public class Main {
    static int S, P;
    static String DNA;
    static int[] ACGT = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");

        int S = Integer.parseInt(input1[0]);
        int P = Integer.parseInt(input1[1]);
        DNA = br.readLine();
        String[] input2 = br.readLine().split(" ");

        for(int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(input2[i]);
        }

        int[][] acc = new int[S + 1][4];
        for(int i = 1; i <= S; i++) {
            acc[i][0] = acc[i - 1][0] + (DNA.charAt(i - 1) == 'A' ? 1 : 0);
            acc[i][1] = acc[i - 1][1] + (DNA.charAt(i - 1) == 'C' ? 1 : 0);
            acc[i][2] = acc[i - 1][2] + (DNA.charAt(i - 1) == 'G' ? 1 : 0);
            acc[i][3] = acc[i - 1][3] + (DNA.charAt(i - 1) == 'T' ? 1 : 0);
        }

        int count = 0;
        int i = 0;
        int j = P - 1;

        while(j < DNA.length()) {
            int A = acc[j + 1][0] - acc[i][0];
            int C = acc[j + 1][1] - acc[i][1];
            int G = acc[j + 1][2] - acc[i][2];
            int T = acc[j + 1][3] - acc[i][3];

            if(A >= ACGT[0] && C >= ACGT[1] && G >= ACGT[2] && T >= ACGT[3]) {
                count++;
            }
            i++; j++;
        }

        System.out.println(count);
    }
}
