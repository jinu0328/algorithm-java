import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new List[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        List<Integer> nodes = tree[node];
        for(Integer current : nodes) {
            if(!visited[current]) {
                parent[current] = node;
                dfs(current);
            }
        }
    }
}