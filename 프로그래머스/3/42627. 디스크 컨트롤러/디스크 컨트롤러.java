import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> waiting = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.start - o2.start;
            }
        });
        
        PriorityQueue<Job> disk = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.take == o2.take) {
                    if(o1.start == o2.start) {
                        return o1.id - o2.id;
                    }
                    return o1.start - o2.start;
                }
                return o1.take - o2.take;
            }
        });
        
        for(int i = 0; i < jobs.length; i++) {
            waiting.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        int current = waiting.peek().start;
        List<Integer> result = new ArrayList<>();
        while(!waiting.isEmpty() || !disk.isEmpty()) {
            while(!waiting.isEmpty() && waiting.peek().start <= current) {
                disk.add(waiting.poll());
            }
            if(disk.isEmpty()) {
                current = waiting.peek().start;
                continue;
            }
            Job currentJob = disk.poll();
            current += currentJob.take;
            result.add(current - currentJob.start);
        }
        
        int size = result.size();
        return result.stream().mapToInt(i -> i).sum() / size;
    }
    
    static class Job {
        int id;
        int start;
        int take;
        
        public Job(int id, int start, int take) {
            this.id = id;
            this.start = start;
            this.take = take;
        }
    }
}