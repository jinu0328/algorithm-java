import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static int count = 0;

    // 첫째 줄에는 컴퓨터의 수가 주어진다.
    // 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
    // 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
    // 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        while(M-- > 0) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;

            graph[start].add(end);
            graph[end].add(start);
        }

        visited = new boolean[N];
        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int v) {
        visited[v] = true;

        List<Integer> computers = graph[v];

        for(Integer computer : computers) {
            if(!visited[computer]) {
                count++;
                dfs(computer);
            }
        }
    }
}
