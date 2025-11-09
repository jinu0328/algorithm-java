import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++) {
            boolean check = false;
            if(!visited[i]) {
                check = true;
                visited[i] = true;
            }
            
            queue.offer(i);
            while(!queue.isEmpty()) {
                int[] current = computers[queue.poll()];
                for(int j = 0; j < current.length; j++) {
                    if(!visited[j] && current[j] == 1) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            
            if(check) {
                count++;
            }
        }
        
        return count;
    }
}