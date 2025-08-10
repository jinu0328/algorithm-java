import java.util.ArrayList;
import java.util.List;

class Solution {
    int result = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        for(int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for(int j = 0; j < wires.length; j++) {
                if(i == j) {
                    continue;
                }

                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, graph, visited);
            
            int otherCount = n - count;
            int diff = Math.abs(count - otherCount);
            
            result = Math.min(result, diff);
        }
        return result;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }
        
        return count;
    }
}