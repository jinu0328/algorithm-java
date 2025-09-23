import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        char prev = ' ';
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;
        for(char c : input) {
            if(c == '(') {
                deque.add(c);
            }
            else {
                if(prev == '(') {
                    deque.pollLast();
                    result += deque.size();
                } else {
                    deque.pollLast();
                    result += 1;
                }
            }
            prev = c;
        }

        System.out.println(result);
    }
}
// )
//
// 3 3 3 2 1 12
