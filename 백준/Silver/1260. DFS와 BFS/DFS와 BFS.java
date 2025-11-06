import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            graph.get(node1 - 1).add(node2);
            graph.get(node2 - 1).add(node1);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph.get(i));
        }

        isVisited = new boolean[N];
        dfs(M);
        sb.append("\n");

        isVisited = new boolean[N];
        bfs(M);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        int index = start - 1;
        if (isVisited[index]) {
            return;
        }

        isVisited[index] = true;
        sb.append(start).append(" ");

        for (int neighbor : graph.get(index)) {
            dfs(neighbor);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int neighbor : graph.get(current - 1)) {
                if (!isVisited[neighbor - 1]) {
                    isVisited[neighbor - 1] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
