import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String input = br.readLine();
            String realInput = input.substring(1, input.length() - 1);
            String[] realRealInput = realInput.split(",");

            for(int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(realRealInput[i]));
            }

            boolean check = true;
            boolean passed = true;
            for(char command : commands) {
                if(command == 'R') {
                    check = !check;
                    continue;
                }

                if(deque.isEmpty()) {
                    passed = false;
                    break;
                }

                if(check) {
                    deque.pollFirst();
                    continue;
                }
                deque.pollLast();
            }

            if(passed) {
                if(deque.isEmpty()) {
                    bw.write("[]\n");
                    continue;
                }
                if(check) {
                    bw.write("[");
                    while(deque.size() > 1) {
                        bw.write(deque.pollFirst() + ",");
                    }
                    bw.write(deque.pollFirst() + "]\n");
                } else {
                    bw.write("[");
                    while(deque.size() != 1) {
                        bw.write(deque.pollLast() + ",");
                    }
                    bw.write(deque.pollLast() + "]\n");
                }
            } else {
                bw.write("error\n");
            }
        }

        bw.flush();
    }
}
