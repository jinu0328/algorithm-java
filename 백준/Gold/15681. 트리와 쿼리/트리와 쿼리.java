import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int N, R, Q;
    static int[] children;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken(" "));
        R = Integer.parseInt(st.nextToken(" "));
        Q = Integer.parseInt(st.nextToken(" "));

        children = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken(" "));
            int node2 = Integer.parseInt(st.nextToken(" "));

            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        getChildren(R);

        while(Q-- > 0) {
            int q = Integer.parseInt(br.readLine());
            bw.write(children[q] + "\n");
        }
        bw.flush();
    }

    private static int getChildren(int R) {
        if(children[R] != 0) {
            return children[R];
        }
        visited[R] = true;
        int count = 1;
        for(int node : tree[R]) {
            if(!visited[node]) {
                count += getChildren(node);
            }
        }

        children[R] = count;
        return children[R];
    }
}
