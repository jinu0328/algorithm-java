import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        int count = 0;
        for(int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int target = command[2] - 1;
            
            int[] tmp = new int[end - start + 1];
            int index = 0;
            for(int i = start; i <= end; i++) {
                tmp[index++] = array[i];
            }
            
            Arrays.sort(tmp);
            result[count++] = tmp[target];
        }
        
        return result;
    }
}