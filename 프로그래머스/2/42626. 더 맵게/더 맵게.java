import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int min = 1000000;
        for(int scov : scoville) {
            queue.add(scov);
            min = Math.min(min, scov);
        }
        
        boolean success = true;
        int count = 0;
        while(min < K) {
            if(queue.size() < 2) {
                success = false;
                break;
            }
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second * 2;
            queue.add(sum);
            min = queue.peek();
            count++;
        }
        
        return success ? count : -1;
    }
}