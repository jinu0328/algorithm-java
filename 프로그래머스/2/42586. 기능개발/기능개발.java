import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> jobs = new ArrayDeque<>();
        for(int i = 0; i < speeds.length; i++) {
            jobs.add(new Job(progresses[i], speeds[i]));
        }
        
        List<Integer> result = new ArrayList<>();
        do {
            Job currentJob = jobs.peek();
            int times = currentJob.getRemainTimes();
            for(Job job : jobs) {
                job.proceed(times);
            }
            int count = 0;
            while(!jobs.isEmpty()) {
                Job job = jobs.peek();
                if(job.progress >= 100) {
                    jobs.poll();
                    count++;
                }
                else {
                    break;
                }
            }
            result.add(count);
        } while(!jobs.isEmpty());
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    static class Job {
        int progress;
        int speed;
        
        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public int getRemainTimes() {
            int remain = 100 - progress;
            if(remain % speed == 0) {
                return remain / speed;
            }
            return remain / speed + 1;
        }
        
        public void proceed(int times) {
            progress += speed * times;
        }
    }
}