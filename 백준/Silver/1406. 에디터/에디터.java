import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> it = list.listIterator(list.size()); // 커서 맨 뒤로 시작

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (it.hasPrevious()) it.previous();
                    break;
                case 'D':
                    if (it.hasNext()) it.next();
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P':
                    char c = command.charAt(2); // "P x"에서 x 추출
                    it.add(c);
                    break;
            }
        }

        for (char c : list) {
            bw.write(c);
        }

        bw.flush();
    }
}
