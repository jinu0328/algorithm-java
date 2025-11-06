import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int candidate = 0;
        for(int[] size : sizes) {
            max = Math.max(max, Math.max(size[0], size[1]));
            candidate = Math.max(candidate, Math.min(size[0], size[1]));
        }
        
        return max * candidate;
    }
}