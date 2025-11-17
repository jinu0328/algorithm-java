import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[] initial = {0, 0};
        queue.add(initial);
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int sum = current[0];
            int count = current[1];
            if(count == numbers.length) {
                if(sum == target) {
                    answer++;
                }
                continue;
            }
            
            queue.offer(new int[]{sum + numbers[count], count + 1});
            queue.offer(new int[]{sum - numbers[count], count + 1});
        }
        
        return answer;
    }
}
