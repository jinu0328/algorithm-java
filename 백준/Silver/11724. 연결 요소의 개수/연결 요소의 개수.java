import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    // 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
// (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N × (N - 1) / 2)
// 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
// (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 점점 개수
        M = scanner.nextInt(); // 간선 개수

        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            graph[start].add(end);
            graph[end].add(start);
        }

        visited = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int v) {
        visited[v] = true;

        List<Integer> list = graph[v];
        for (Integer num : list) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()) {
            int target = queue.poll();
            List<Integer> list = graph[target];
            for(Integer num : list) {
                if(!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}
