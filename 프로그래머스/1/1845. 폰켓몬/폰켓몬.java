import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int possibleNum = nums.length / 2;
        Set<Integer> categories = new HashSet<>();
        
        for(Integer num : nums) {
            categories.add(num);
        }
        
        return Math.min(possibleNum, categories.size());
    }
}