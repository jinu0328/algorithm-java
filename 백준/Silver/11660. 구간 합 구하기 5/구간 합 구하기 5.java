import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] board = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            board[i] = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] accRow = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                accRow[i][j] =  accRow[i][j-1] + board[i][j];
            }
        }

        while(M-- > 0) {
            int sum = 0;
            String[] input2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(input2[0]);
            int y1 = Integer.parseInt(input2[1]);
            int x2 = Integer.parseInt(input2[2]);
            int y2 = Integer.parseInt(input2[3]);

            for(int i = x1; i <= x2; i++) {
                sum += accRow[i][y2] - accRow[i][y1 - 1];
            }

            bw.write(sum + "\n");
        }

        bw.flush();
    }
}