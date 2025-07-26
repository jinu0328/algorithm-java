import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> processes = new ArrayDeque<>();

        for(int i = 0; i < priorities.length; i++) {
            if(i == location) {
                processes.add(new Process(priorities[i], true));
            }
            else {
                processes.add(new Process(priorities[i]));
            }
        }

        int count = 0;
        while(true) {
            Process process = processes.poll();
            if(hasBigger(process.priority, processes)) {
                processes.add(process);
            }
            else {
                count++;
                if(process.wantToKnow) {
                    return count;
                }
            }
        }
    }

    private boolean hasBigger(int priority, Queue<Process> processes) {
        return processes.stream()
                .anyMatch(process -> process.priority > priority);
    }

    static class Process {
        int priority;
        boolean wantToKnow = false;

        Process(int priority) {
            this.priority = priority;
        }

        Process(int priority, boolean wantToKnow) {
            this.priority = priority;
            this.wantToKnow = wantToKnow;
        }
    }
}


/*

 */