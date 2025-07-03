import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> results = new HashMap<>();

        for(String par : participant) {
            results.put(par, results.getOrDefault(par, 0) + 1);
        }

        for(String name : completion) {
            results.put(name, results.get(name) - 1);
        }

        for(String name : results.keySet()) {
            if(results.get(name) != 0) {
                return name;
            }
        }
        return "";
    }
}