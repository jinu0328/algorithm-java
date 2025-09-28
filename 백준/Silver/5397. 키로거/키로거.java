import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            char[] input = br.readLine().toCharArray();
            List<Character> deque = new LinkedList<>();
            int index = 0;
            int lastIndex = 0;
            for(int i = 0; i < input.length; i++) {
                char c = input[i];
                if(c == '<') {
                    if(index <= 0) {
                        continue;
                    }
                    index--;
                }
                else if(c == '>') {
                    if(index >= lastIndex) {
                        continue;
                    }
                    index++;
                }
                else if(c == '-') {
                    if(deque.isEmpty()) {
                       continue;
                    }
                    if(index <= 0) {
                        continue;
                    }
                    deque.remove(--index);
                    lastIndex--;
                }
                else {
                    if(index == lastIndex) {
                        deque.add(c);
                        index++;
                        lastIndex++;
                    }
                    else {
                        deque.add(index, c);
                        index++;
                        lastIndex++;
                    }
                }
            }
            for(Character c : deque) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
