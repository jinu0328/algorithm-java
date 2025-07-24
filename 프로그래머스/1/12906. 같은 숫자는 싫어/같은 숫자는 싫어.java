import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> numbers = new ArrayList<>();
        
        for(int num : arr) {
            queue.add(num);
        }

        numbers.add(queue.remove());
        while(queue.size() != 0) {
            Integer removed = queue.remove();
            if(!numbers.get(numbers.size() - 1).equals(removed)) {
                numbers.add(removed);
            }
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
