import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S; // 신맛
    static int[] B; // 쓴맛
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);

        System.out.println(answer);
    }

    /**
     * 
     * @param idx 현재 인덱스
     * @param sour 신맛 (곱)
     * @param bitter 쓴맛 (합)
     * @param count 지금까지 선택한 재료 개수
     */
    static void dfs(int idx, int sour, int bitter, int count) {
        if (idx == N) {
            if (count > 0) { // 공집합 제외
                answer = Math.min(answer, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료 사용 O
        dfs(idx + 1, sour * S[idx], bitter + B[idx], count + 1);

        // 현재 재료 사용 X
        dfs(idx + 1, sour, bitter, count);
    }
}
