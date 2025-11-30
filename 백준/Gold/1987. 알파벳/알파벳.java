import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int r, c;
    static char[][] board;
    static int UP = -1;
    static int DOWN = 1;
    static int RIGHT = 1;
    static int LEFT = -1;
    static int result = Integer.MIN_VALUE;
    static Map<Character, Boolean> count = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        board = new char[r][c];
        for(int i = 0; i < r; i++) {
            String input = sc.nextLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        count.put(board[0][0], true);
        solve(0, 0, 1);
        System.out.println(result);
    }

    private static void solve(int currentR, int currentC, int depth) {
        // 재귀
        if(currentR > 0) {
            char next = board[currentR + UP][currentC];
            if(!count.containsKey(next) || !count.get(next)) {
                count.put(next, true);
                solve(currentR + UP, currentC, depth + 1);
                count.put(next, false);
            }
        }
        if(currentR < r - 1) {
            char next = board[currentR + DOWN][currentC];
            if(!count.containsKey(next) || !count.get(next)) {
                count.put(next, true);
                solve(currentR + DOWN, currentC, depth + 1);
                count.put(next, false);
            }
        }
        if(currentC > 0) {
            char next = board[currentR][currentC + LEFT];
            if(!count.containsKey(next) || !count.get(next)) {
                count.put(next, true);
                solve(currentR, currentC + LEFT, depth + 1);
                count.put(next, false);
            }
        }
        if(currentC < c - 1) {
            char next = board[currentR][currentC + RIGHT];
            if(!count.containsKey(next) || !count.get(next)) {
                count.put(next, true);
                solve(currentR, currentC + RIGHT, depth + 1);
                count.put(next, false);
            }
        }

        result = Math.max(result, depth);
    }
}