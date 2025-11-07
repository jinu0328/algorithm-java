import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>();
    boolean[] visited;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs("", numbers);
    
        return (int) candidates.stream()
            .filter(c -> isPrime(c))
            .count();
        
    }
    
    private boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(String start, String numbers) {
        if(!start.isEmpty()) {
            candidates.add(Integer.parseInt(start));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(start + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
}