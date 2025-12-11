import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c;
    static int[] sushi;
    static int[] eated;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n];
        eated = new int[d + 1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 초기 k개 세팅
        for (int i = 0; i < k; i++) {
            if (eated[sushi[i]] == 0) count++;
            eated[sushi[i]]++;
        }

        // 쿠폰 포함 여부로 초기 max 계산
        int maxLen = count + (eated[c] == 0 ? 1 : 0);

        // 슬라이딩 윈도우
        for (int i = 1; i < n; i++) {

            // 새로 들어오는 초밥
            int end = (i + k - 1) % n;
            if (eated[sushi[end]] == 0) count++;
            eated[sushi[end]]++;

            // 빠지는 초밥
            eated[sushi[i - 1]]--;
            if (eated[sushi[i - 1]] == 0) count--;

            // 쿠폰 포함 여부 체크
            int curMax = count + (eated[c] == 0 ? 1 : 0);

            if (curMax > maxLen) {
                maxLen = curMax;
            }
        }

        System.out.println(maxLen);
    }
}
