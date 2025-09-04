import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] spot = new int[N];
        for (int i = 0; i < N; i++) {
            spot[i] = Integer.parseInt(br.readLine());
        }

        // 누적합
        int[] prefix = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + spot[i-1];
        }
        int total = prefix[N];

        int answer = 0;
        int j = 1;
        for (int i = 0; i < N; i++) {
            while (j < N && prefix[j] - prefix[i] <= total / 2) {
                int clockwise = prefix[j] - prefix[i];
                int counter = total - clockwise;
                answer = Math.max(answer, Math.min(clockwise, counter));
                j++;
            }
            // while 빠져나온 뒤 j 위치도 확인
            if (j < N) {
                int clockwise = prefix[j] - prefix[i];
                int counter = total - clockwise;
                answer = Math.max(answer, Math.min(clockwise, counter));
            }
        }

        System.out.println(answer);
    }
}
