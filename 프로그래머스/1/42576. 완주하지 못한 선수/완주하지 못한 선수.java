import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            if(map.get(name) == 1) {
                map.remove(name);
            }
            else {
                map.put(name, map.get(name) - 1);
            }
            
        }
        
        return String.valueOf(map.keySet().stream().findFirst().get());    
    }
}