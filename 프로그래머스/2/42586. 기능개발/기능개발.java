import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> tasks = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            tasks.add(new Task(progresses[i], speeds[i]));
        }

        while (!tasks.isEmpty()) {
            tasks.forEach(Task::proceed);
            int count = 0;
            while (!tasks.isEmpty() && tasks.peek().isCompleted) {
                tasks.remove();
                count++;
            }

            if(count != 0) {
                result.add(count);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Task {
        int progress;
        int speed;
        boolean isCompleted = false;

        Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        void proceed() {
            progress += speed;
            if (progress >= 100) {
                isCompleted = true;
            }
        }
    }
}


