import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Job> queue = new ArrayDeque<>();
        int[] priority = new int[10];
        for(int i = 0; i < priorities.length; i++) {
            if(i == location) {
                queue.add(new Job(priorities[i], true));
            }
            else {
                queue.add(new Job(priorities[i], false));
            }
            
            priority[priorities[i]]++;
        }
        int count = 0;
        
        while(true) {
            Job current = queue.poll();
            boolean isFirst = true;
            for(int i = current.priority + 1; i < priority.length; i++) {
                if(priority[i] > 0) {
                    queue.add(current);
                    isFirst = false;
                    break;
                }
            }
            if(!isFirst) {
                continue;
            }
            count++;
            priority[current.priority]--;
            if(current.isTarget) {
                break;
            }
        }
        
        return count;
    }
    
    static class Job {
        int priority;
        boolean isTarget;
        
        public Job(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
    }
}