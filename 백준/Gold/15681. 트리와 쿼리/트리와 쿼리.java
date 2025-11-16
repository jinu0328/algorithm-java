import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    static int N, R, Q;
    static int[] children;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        parent = new int[N + 1];
        tree = new List[N + 1];
        children = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            int node1 = Integer.parseInt(input2[0]);
            int node2 = Integer.parseInt(input2[1]);

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        getChildren(R);
        while(Q-- > 0) {
            System.out.println(children[Integer.parseInt(br.readLine())]);
        }
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