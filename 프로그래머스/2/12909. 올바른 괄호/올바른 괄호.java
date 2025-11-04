import java.util.*;

class Solution {
    boolean solution(String s) {
        List<Character> inputs = new ArrayList<>();
        boolean result = true;
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(inputs.isEmpty()) {
                inputs.add(current);
                continue;
            }
            if(current == ')') {
                if(inputs.isEmpty() || inputs.get(inputs.size() - 1) != '(') {
                    result = false;
                    break;
                }
                else {
                    inputs.remove(inputs.size() - 1);
                }
            } else {
                inputs.add(current);
            }
        }
        
        
        return inputs.isEmpty();
    }
}