import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        String ex = "";
        for(int i = 0; i < N; i++) {
            if(Objects.equals(ex, words[i])) {
                ex = words[i];
                continue;
            }
            bw.write(words[i] + "\n");
            ex = words[i];
        }

        bw.flush();
    }
}