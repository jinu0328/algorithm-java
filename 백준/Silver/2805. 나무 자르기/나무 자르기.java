import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > maxHeight) maxHeight = tree[i];
        }

        int low = 0, high = maxHeight, result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long remain = getRemain(tree, mid);

            if (remain < M) {
                high = mid - 1;
            } else {
                result = mid; // mid가 정답 후보
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long getRemain(int[] tree, int mid) {
        long remain = 0;
        for (int h : tree) {
            if (h > mid) remain += (h - mid);
        }
        return remain;
    }
}
