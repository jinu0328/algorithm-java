import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new int[]{i, j});   // 집
                if (val == 2) chickens.add(new int[]{i, j}); // 치킨집
            }
        }

        // 조합 탐색
        comb(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    // 치킨집 M개 선택하는 조합
    static void comb(int start, int depth, List<int[]> selected) {
        if (depth == M) {
            answer = Math.min(answer, calcCityChickenDist(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            comb(i + 1, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    // 도시 치킨 거리 계산
    static int calcCityChickenDist(List<int[]> selected) {
        int sum = 0;
        for (int[] h : houses) {
            int dist = Integer.MAX_VALUE;
            for (int[] c : selected) {
                dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
            }
            sum += dist;
        }
        return sum;
    }
}
