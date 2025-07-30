import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업 대기 큐: 작업 소요 시간 기준 오름차순
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.takenTime));

        // 작업 리스트 초기화 및 start 시간 기준 정렬
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            tasks.add(new Task(jobs[i][0], jobs[i][1]));
        }
        tasks.sort(Comparator.comparingInt(t -> t.start));

        int current = 0;
        int taskIndex = 0;        // tasks 리스트 순회용 인덱스
        int completedCount = 0;
        int totalReturnTime = 0;

        while (completedCount < jobs.length) {
            // 현재 시간에 시작 가능한 작업들을 큐에 추가
            while (taskIndex < tasks.size() && tasks.get(taskIndex).start <= current) {
                taskQueue.offer(tasks.get(taskIndex));
                taskIndex++;
            }

            if (taskQueue.isEmpty()) {
                // 처리할 작업 없으면 다음 작업 시작 시간으로 점프
                current = tasks.get(taskIndex).start;
                continue;
            }

            // 작업 수행
            Task task = taskQueue.poll();
            current += task.takenTime;
            totalReturnTime += current - task.start;
            completedCount++;
        }

        return totalReturnTime / jobs.length;
    }

    static class Task {
        int start;
        int takenTime;

        Task(int start, int takenTime) {
            this.start = start;
            this.takenTime = takenTime;
        }
    }
}
