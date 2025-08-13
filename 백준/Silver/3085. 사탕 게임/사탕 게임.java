import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();

        int max = getMaxCandy(board); // 원판 자체의 최대도 고려

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 오른쪽과 교환
                if (y + 1 < N && board[x][y] != board[x][y + 1]) {
                    swap(board, x, y, x, y + 1);
                    max = Math.max(max, getMaxCandy(board));
                    swap(board, x, y, x, y + 1); // 원복
                }
                // 아래와 교환
                if (x + 1 < N && board[x][y] != board[x + 1][y]) {
                    swap(board, x, y, x + 1, y);
                    max = Math.max(max, getMaxCandy(board));
                    swap(board, x, y, x + 1, y); // 원복
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }

    private static int getMaxCandy(char[][] b) {
        int max = 1;

        // 가로 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (b[i][j] == b[i][j - 1]) count++;
                else count = 1;
                if (count > max) max = count;
            }
        }

        // 세로 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (b[i][j] == b[i - 1][j]) count++;
                else count = 1;
                if (count > max) max = count;
            }
        }

        return max;
    }

    private static void swap(char[][] b, int x1, int y1, int x2, int y2) {
        char tmp = b[x1][y1];
        b[x1][y1] = b[x2][y2];
        b[x2][y2] = tmp;
    }
}
