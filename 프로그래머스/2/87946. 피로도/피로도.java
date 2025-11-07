import java.util.*;

class Solution {
    boolean[] isVisited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int count) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                isVisited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}