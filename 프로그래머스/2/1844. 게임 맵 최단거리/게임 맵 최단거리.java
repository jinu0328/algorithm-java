import java.util.*;

class Solution {
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1}); // y, x, distance
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], dist = cur[2];

            if (y == n - 1 && x == m - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, dist + 1});
                }
            }
        }
        return -1;
    }
}
