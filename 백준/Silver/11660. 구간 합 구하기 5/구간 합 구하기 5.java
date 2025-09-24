import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] board;


    public static void main(String[] args) throws IOException {
      String[] input = br.readLine().split(" ");
      N = Integer.parseInt(input[0]);
      M = Integer.parseInt(input[1]);

      board = new int[N + 1][N + 1];
      for(int i = 1; i <= N; i++) {
          board[i] = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      int[][] acc = new int[N + 1][N + 1];
      for(int i = 1; i <= N; i++) {
          for(int j = 1; j <= N; j++) {
              acc[i][j] = acc[i][j - 1] + board[i][j];
          }
      }

      while(M-- > 0) {
          String[] input2 = br.readLine().split(" ");
          int x1, x2, y1, y2;
          x1 = Integer.parseInt(input2[0]);
          y1 = Integer.parseInt(input2[1]);
          x2 = Integer.parseInt(input2[2]);
          y2 = Integer.parseInt(input2[3]);

          int sum = 0;
          for(int i = x1; i <= x2; i++) {
              sum += acc[i][y2] - acc[i][y1 - 1];
          }

          bw.write(sum + "\n");
      }
      bw.flush();
    }
}
