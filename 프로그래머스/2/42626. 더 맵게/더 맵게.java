import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> scovilles = new PriorityQueue<>();

        for(int scov : scoville) {
            scovilles.add(scov);
        }

        int count = 0;
        while(scovilles.stream()
                .anyMatch(value -> value < K)) {

            if(scovilles.size() < 2) {
                return -1;
            }
            int mixed = scovilles.poll() + 2 * scovilles.poll();
            scovilles.add(mixed);
            count++;
        }

        return count;
    }
}