import java.io.*;
import java.util.*;

public class Main {
    static int N, B, W;
    static int[] bAcc, wAcc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        W = Integer.parseInt(input[2]);

        char[] street = (" " + br.readLine()).toCharArray();

        bAcc = new int[N + 1];
        wAcc = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            bAcc[i] = bAcc[i - 1] + (street[i] == 'B' ? 1 : 0);
            wAcc[i] = wAcc[i - 1] + (street[i] == 'W' ? 1 : 0);
        }

        int result = 0;
        int left = 1, right = 1;

        while (right <= N) {
            int bCount = bAcc[right] - bAcc[left - 1];
            int wCount = wAcc[right] - wAcc[left - 1];

            if (bCount <= B && wCount >= W) {
                result = Math.max(result, right - left + 1);
                right++; // 구간 확장
            } else if (bCount > B) {
                left++; // B 초과 시 왼쪽 줄이기
            } else { // W 부족
                right++; // W 부족 시 구간 확장
            }
        }

        System.out.println(result);

    }
}
