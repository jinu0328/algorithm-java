import java.util.Scanner;

public class Main {
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int[][] board = new int[11][11];
    static int result = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        solve(0, 0, 0);
        if(result == 26) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    static void solve(int row, int col, int count) {
        if(result <= count) {
            return;
        }

        // base case
        findNext(row, col);
        if(nextRow == -1 && nextCol == -1) {
            result = count;
            return;
        }

        // recursive case
        int r = nextRow;
        int c = nextCol;

        for(int size = 1; size <= 5; size++) {
            if(paper[size] == 0) {
                continue;
            }
            if(isValid(r, c, size)) {
                paper[size]--;
                fill(r, c, size, 0);
                solve(r, c, count + 1);
                fill(r, c, size, 1);
                paper[size]++;
            }
        }
    }

    static void fill(int row, int col, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][col + j] = color;
            }
        }
    }

    static boolean isValid(int row, int col, int size) {
        if(row + size > 10 || col + size > 10) {
            return false;
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if(board[row + r][col + c] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static int nextRow = 0;
    static int nextCol = 0;
    static void findNext(int row, int col) {
        for(int r = row; r <= 10; r++) {
            for (int c = 0; c <= 10; c++) {
                if(board[r][c] == 1) {
                    nextRow = r;
                    nextCol = c;
                    return;
                }
            }
        }
        nextRow = -1;
        nextCol = -1;
    }
}