import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> queue = new LinkedList<>();
        
        for(int num : arr) {
            if(!queue.isEmpty() && queue.get(queue.size() - 1) == num) {
                continue;
            }
            queue.add(num);
        }

        return queue.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}