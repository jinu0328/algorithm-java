import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] board;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N  = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        board = new char[N];
        Arrays.fill(board, '?');

        int currentIndex = 0;
        boolean isPossible = true;
        while(K-- > 0) {
            String[] nextInput = br.readLine().split(" ");
            int S  = Integer.parseInt(nextInput[0]);
            char word = nextInput[1].charAt(0);
            currentIndex = (currentIndex + S) % board.length;


            if(board[currentIndex] != '?' && board[currentIndex] != word) {
                isPossible = false;
                break;
            }

            if(board[currentIndex] != word && alreadyHas(word)) {
                isPossible = false;
                break;
            }

            board[currentIndex] = word;
        }

        if(!isPossible) {
            System.out.println("!");
            return;
        }

        int count = 0;

        do {
            System.out.print(board[currentIndex]);
            currentIndex = (currentIndex - 1 + board.length) % board.length; // 한 칸 뒤로
            count++;
        } while (count < board.length);

    }

    private static boolean alreadyHas(char word) {
        for(char c : board) {
            if(c == word) {
                return true;
            }
        }
        return false;
    }
}
