import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업 대기 큐 (소요 시간 짧은 순)
        Queue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());

        // 처리되지 않은 작업 목록
        List<Task> tasks = new ArrayList<>();

        // 처리 완료된 작업 목록 (평균 계산용)
        List<Task> processedTasks = new ArrayList<>();

        // 작업들 초기화
        for (int i = 0; i < jobs.length; i++) {
            tasks.add(new Task(i, jobs[i][0], jobs[i][1]));
        }

        int completeCount = 0;

        for (int current = 0; ; current++) {
            // 현재 시간에 시작 가능한 작업들을 큐에 추가하고, tasks 목록에서는 제거
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.start <= current) {
                    taskQueue.add(task);
                    iterator.remove(); // 큐에 넣은 건 다시 안 보게
                }
            }

            // 작업 수행
            if (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                current += task.takenTime;
                task.end(current);
                processedTasks.add(task); // 완료된 작업 저장
                completeCount++;

                current--; // for 루프에서 한 번 더 증가하므로 보정
            }

            // 모든 작업 완료 시 종료
            if (completeCount == jobs.length) break;
        }

        // 평균 반환 시간 계산
        return processedTasks.stream()
                .mapToInt(task -> task.returnTime)
                .sum() / processedTasks.size();
    }

    static class Task {
        int number;
        int start;
        int takenTime;
        int returnTime;

        public Task(int number, int start, int takenTime) {
            this.number = number;
            this.start = start;
            this.takenTime = takenTime;
        }

        public void end(int endTime) {
            this.returnTime = endTime - start;
        }
    }

    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            if (o1.takenTime == o2.takenTime) {
                if (o1.start == o2.start) {
                    return o1.number - o2.number;
                }
                return o1.start - o2.start;
            }
            return o1.takenTime - o2.takenTime;
        }
    }
}
