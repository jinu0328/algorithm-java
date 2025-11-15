import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums, output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++) {
            output[depth] = nums[i];
            dfs(depth + 1, i);
        }
    }
}
