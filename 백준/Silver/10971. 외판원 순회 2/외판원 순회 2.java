import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N;
    static List<Integer>[] graph;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new List[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                graph[i].add(Integer.parseInt(st.nextToken(" ")));
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            solve(i, 0, 1, i);
        }

        System.out.println(result);
    }

    private static void solve(int current, int cost, int count, int start) {
        if (cost >= result) return;

        if(count == N) {
            int lastCost = graph[current].get(start);
            if(lastCost != 0) {
                cost += lastCost;
                result = Math.min(result, cost);
            }
            return;
        }

        List<Integer> nodes = graph[current];
        for(int i = 0; i < nodes.size(); i++) {
            int nextCost = nodes.get(i);
            if(!visited[i] && nextCost != 0) {
                visited[i] = true;
                solve(i, cost + nextCost, count + 1, start);
                visited[i] = false;
            }
        }
    }
}
