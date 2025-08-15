import java.io.*;

public class Main {
    static final char DOT = 46;
    static final char UP_DOWN = 124;
    static final char LEFT_RIGHT = 45;
    static final char BOTH = 43;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;
    static int N;
    static int currentX = 0;
    static int currentY = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = DOT;
            }
        }

        String commands = br.readLine();

        for(int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            moveRobot(command);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                bw.write(board[j][i]);
            }
            bw.write("\n");
        }

        bw.flush();
    }

    private static void moveRobot(char command) {
        if(command == 'U') {
            if(currentY - 1 == -1) {
                return;
            }
            markUpDown(currentX, currentY);
            markUpDown(currentX, --currentY);
        }
        else if(command == 'D') {
            if(currentY + 1 == N) {
                return;
            }
            markUpDown(currentX, currentY);
            markUpDown(currentX, ++currentY);
        }
        else if (command == 'L') {
            if(currentX - 1 == -1) {
                return;
            }
            markLeftRight(currentX, currentY);
            markLeftRight(--currentX, currentY);
        }
        else if (command == 'R') {
            if(currentX + 1 == N) {
                return;
            }
            markLeftRight(currentX, currentY);
            markLeftRight(++currentX, currentY);
        }
    }

    private static void markLeftRight(int x, int y) {
        if(board[x][y] == DOT) {
            board[x][y] = LEFT_RIGHT;
        }
        else if(board[x][y] == UP_DOWN) {
            board[x][y] = BOTH;
        }
    }

    private static void markUpDown(int x, int y) {
        if(board[x][y] == DOT) {
            board[x][y] = UP_DOWN;
        }
        else if(board[x][y] == LEFT_RIGHT) {
            board[x][y] = BOTH;
        }
    }
}
