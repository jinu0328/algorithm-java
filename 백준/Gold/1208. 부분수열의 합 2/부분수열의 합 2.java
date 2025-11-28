import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] nums;
    static long result = 0;
    static int status = -1;
    static int LEFT = 0;
    static int RIGHT = 1;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken(" "));
        S = Integer.parseInt(st.nextToken(" "));
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken(" "));
        }

        status = LEFT;
        solve(0, N/2, 0);
        status = RIGHT;
        solve(N/2, N, 0);

        System.out.println(S == 0 ? result - 1 : result);
    }

    private static void solve(int index, int max, int sum) {
        if(index == max) {
            if(status == LEFT) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            } else {
                result += map.getOrDefault(S - sum, 0);
            }
            return;
        }

        solve(index + 1, max, sum);
        solve(index + 1, max, sum + nums[index]);
    }
}
