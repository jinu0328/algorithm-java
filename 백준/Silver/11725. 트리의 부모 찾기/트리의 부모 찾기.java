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

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            Integer parentId = queue.poll();
            List<Integer> current = tree[parentId];
            for(Integer number : current) {
                if(!visited[number]) {
                    visited[number] = true;
                    parent[number] = parentId;
                    queue.add(number);
                }
            }
        }

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}