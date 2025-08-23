import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static char[][] board;


    public static void main(String[] args) throws IOException {
         N = Integer.parseInt(br.readLine());
         board = new char[N][N];
         for(int i = 0; i < N; i++) {
             board[i] = br.readLine().toCharArray();
         }

         int count = 0;
         count = Math.max(count, countMax());

         for(int i = 0; i < N; i++) {
             for(int j = 0; j < N - 1; j++) {
                 if(board[i][j] == board[i][j + 1]) {
                     continue;
                 }

                 char tmp = board[i][j + 1];
                 board[i][j + 1] = board[i][j];
                 board[i][j] = tmp;
                 count = Math.max(countMax(), count);
                 tmp = board[i][j + 1];
                 board[i][j + 1] = board[i][j];
                 board[i][j] = tmp;
             }
         }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(board[j][i] == board[j + 1][i]) {
                    continue;
                }

                char tmp = board[j + 1][i];
                board[j + 1][i] = board[j][i];
                board[j][i] = tmp;
                count = Math.max(countMax(), count);
                tmp = board[j + 1][i];
                board[j + 1][i] = board[j][i];
                board[j][i] = tmp;
            }
        }

        System.out.println(count);
    }

    private static int countMax() {
        int count = 0;

        for(int i = 0; i < N; i++) {
            int tmpCount = 1;
            for(int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j - 1]) {
                    tmpCount++;
                } else {
                    tmpCount = 1;
                }
                count = Math.max(count, tmpCount);
            }
        }

        for(int i = 0; i < N; i++) {
            int tmpCount = 1;
            for(int j = 1; j < N; j++) {
                if(board[j][i] == board[j - 1][i]) {
                    tmpCount++;
                } else {
                    tmpCount = 1;
                }
                count = Math.max(count, tmpCount);
            }
        }

        return count;
    }
}
