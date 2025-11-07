class Solution {
    int count = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, visited, computers);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int v, boolean[] visited, int[][] computers) {
        int[] route = computers[v];
        visited[v] = true;
        for(int i = 0; i < route.length; i++) {
            if(!visited[i] && route[i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }
}

