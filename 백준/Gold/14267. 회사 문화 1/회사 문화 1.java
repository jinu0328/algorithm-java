import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] praise;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        tree = new List[n + 1];
        visited = new boolean[n + 1];
        praise = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int master = Integer.parseInt(st.nextToken(" "));
            if(master == -1) {
                continue;
            }
            tree[i].add(master);
            tree[master].add(i);
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            praise[Integer.parseInt(st.nextToken(" "))] += Integer.parseInt(st.nextToken(" "));
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int id = current[0];
            int praiseCount = current[1] + praise[id];
            praise[id] = praiseCount;

            for(int staff : tree[id]) {
                if(!visited[staff]) {
                    visited[staff] = true;
                    queue.add(new int[]{staff, praiseCount});
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            bw.write(praise[i] + " ");
        }
        bw.flush();
    }
}