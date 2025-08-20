import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;
    static final char EXISTS = '*';
    static final char NOT_EXISTS = '.';
    static int N;
    static int M;
    static int T;
    static int K;
    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);
        T = Integer.parseInt(input1[2]);

        board = new char[N + 1][M + 1];

        String[] input2 = br.readLine().split(" ");
        K = Integer.parseInt(input2[0]);
        a = Integer.parseInt(input2[1]);
        b = Integer.parseInt(input2[2]);

        for(int i = 1; i <= N; i++) {
            board[i] = (" " + br.readLine()).toCharArray();
        }

        while(T-- > 0) {
            int[][] acc = getPrefixSum();
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i ,j);
                    if(board[i][j] == EXISTS) {
                        nearAlive--;
                        if(nearAlive < a || nearAlive > b) {
                            board[i][j] = '.';
                        }
                    }
                    else if (nearAlive > a && nearAlive <= b){
                        board[i][j] = '*';
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private static int getRangeSum(int[][] acc, int r, int c) {
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1);
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }

    private static int[][] getPrefixSum() {
        int[][] acc = new int[board.length][board[0].length];

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + (board[i][j] == '*' ? 1 : 0);
            }
        }

        return acc;
    }
}