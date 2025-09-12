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

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        while(N-- > 0) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            if(command.equals("push_back")) {
                int n = Integer.parseInt(input[1]);
                deque.addLast(n);
                continue;
            }
            if(command.equals("push_front")) {
                int n = Integer.parseInt(input[1]);
                deque.addFirst(n);
                continue;
            }
            if(command.equals("pop_back")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(deque.pollLast() + "\n");
                continue;
            }
            if(command.equals("pop_front")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(deque.pollFirst() + "\n");
                continue;
            }
            if(command.equals("size")) {
                bw.write(deque.size() + "\n");
                continue;
            }
            if(command.equals("empty")) {
                int s = deque.isEmpty() ? 1 : 0;
                bw.write(s + "\n");
                continue;
            }
            if(command.equals("back")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(deque.peekLast() + "\n");
                continue;
            }
            if(command.equals("front")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(deque.peekFirst() + "\n");
                continue;
            }
        }

        bw.flush();
    }
}
