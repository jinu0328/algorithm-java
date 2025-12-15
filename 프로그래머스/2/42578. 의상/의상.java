import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> categories = new HashMap<>();
        
        for(String[] cloth : clothes) {
            categories.put(cloth[1], categories.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        for(Integer count : categories.values()) {
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}