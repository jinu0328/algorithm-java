import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int count = 0;
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int V = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            graph.get(node1 - 1).add(node2);
            graph.get(node2 - 1).add(node1);
        }

        isVisited = new boolean[N];
        //dfs(1);
        bfs(1);
        System.out.println(count - 1);
    }

    private static void dfs(int start) {
        int index = start - 1;
        if (isVisited[index]) {
            return;
        }

        isVisited[index] = true;
        count++;

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
            count++;

            for (int neighbor : graph.get(current - 1)) {
                if (!isVisited[neighbor - 1]) {
                    isVisited[neighbor - 1] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
