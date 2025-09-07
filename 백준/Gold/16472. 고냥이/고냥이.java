import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();

        Map<Character, Integer> beta = new HashMap<>();
        int start = 0, end = 0, result = 0;

        while (end < s.length) {
            char c = s[end];
            beta.put(c, beta.getOrDefault(c, 0) + 1);

            while (beta.size() > N) { // 초과하면 start 이동
                char left = s[start];
                beta.put(left, beta.get(left) - 1);
                if (beta.get(left) == 0) beta.remove(left);
                start++;
            }

            result = Math.max(result, end - start + 1);
            end++;
        }

        System.out.println(result);
    }
}
