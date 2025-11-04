import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0, sum = 0;
        for (int t : truck_weights) {
            while (true) {
                time++;
                if (bridge.size() == bridge_length) sum -= bridge.poll();
                if (sum + t <= weight) {
                    bridge.add(t);
                    sum += t;
                    break;
                } else {
                    bridge.add(0); // 1초 흘려보내기
                }
            }
        }
        return time + bridge_length;
    }
}