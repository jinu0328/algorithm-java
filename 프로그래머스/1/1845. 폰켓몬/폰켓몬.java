import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int pick = nums.length / 2;
        Set<Integer> categories = new HashSet<>();
        
        for(Integer num : nums) {
            categories.add(num);
        }
        
        return Math.min(pick, categories.size());
    }
}
