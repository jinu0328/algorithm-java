import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        while(!input.equals(".")) {
            Deque<Character> deque = new ArrayDeque<>();
            String answer = "yes";
            for(char c : input.toCharArray()) {
                if(c == '(' || c == '[') {
                    deque.add(c);
                }
                else if(c == ')') {
                    if(deque.peekLast() == null) {
                        answer = "no";
                        break;
                    }
                    if('(' == deque.peekLast()) {
                        deque.pollLast();
                    } else {
                        answer = "no";
                        break;
                    }
                }
                else if(c == ']') {
                    if(deque.peekLast() == null) {
                        answer = "no";
                        break;
                    }
                    if('[' == deque.peekLast()) {
                        deque.pollLast();
                    } else {
                        answer = "no";
                        break;
                    }
                }
            }

            if(!deque.isEmpty()) {
                answer = "no";
            }

            bw.write(answer + "\n");
            input = br.readLine();
        }

        bw.flush();
    }
}
