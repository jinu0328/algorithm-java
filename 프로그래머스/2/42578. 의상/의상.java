import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        List<Integer> num = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String key : map.keySet()) {
            num.add(map.get(key));
        }
        
        int result = 1;
        
        for(Integer value : num) {
            result *= (value + 1);
        }
        
        return result - 1;
        
    }
}