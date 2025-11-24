import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] nums;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken(" "));
        S = Integer.parseInt(st.nextToken(" "));
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken(" "));
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int sum, int next, int count) {
        if(next == N) {
            if(sum == S && count > 0) {
                result++;
            }
            return;
        }



        dfs(sum + nums[next], next + 1, count + 1);
        dfs(sum, next + 1, count);
    }
}
