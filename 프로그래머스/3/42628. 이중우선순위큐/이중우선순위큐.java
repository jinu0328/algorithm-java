import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        CustomQueue customQueue = new CustomQueue();

        for(String operation : operations) {
            if(operation.startsWith("I")) {
                customQueue.add(Integer.parseInt(operation.split(" ")[1]));
            }
            else {
                if(operation.contains("-")) {
                    customQueue.minPoll();
                }
                else {
                    customQueue.maxPoll();
                }
            }
        }

        int[] result = new int[2];

        result[0] = customQueue.maxPeek();
        result[1] = customQueue.minPeek();

        return result;

    }

    static class CustomQueue {
        Queue<Integer> queue;

        public CustomQueue() {
            this.queue = new PriorityQueue<>();
        }

        public void add(Integer n) {
            queue.add(n);
        }

        public Integer maxPeek() {
            if(queue.isEmpty()) {
                return 0;
            }
            return queue.stream()
                    .max(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    })
                    .get();
        }

        public Integer minPeek() {
            if(queue.isEmpty()) {
                return 0;
            }
            return queue.peek();
        }


        public Integer minPoll() {
            if(queue.isEmpty()) {
                return 0;
            }
            return queue.poll();
        }

        public Integer maxPoll() {
            if(queue.isEmpty()) {
                return 0;
            }

            int max = queue.stream()
                    .max(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    })
                    .get();
            System.out.println(max);
            queue.remove(max);
            return max;
        }
    }
}

