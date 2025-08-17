import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<String> input = new HashSet<>();

        for(int i = 0; i < N; i++) {
            input.add(br.readLine());
        }

        String[] words = new String[input.size()];

        int k = 0;
        for(String in : input) {
            words[k++] = in;
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

        for(int i = 0; i < input.size(); i++) {
            bw.write(words[i] + "\n");
        }

        bw.flush();
    }
}
