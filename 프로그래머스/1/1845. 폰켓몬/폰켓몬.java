import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length; // 포켓몬 수 N/2마리 고를 수 있음
        Map<Integer, Integer> result = new HashMap<>();

        for(int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }

        if(result.size() > N / 2) { // Map의 사이즈가 N/2보다 크다면 다 다른 종류로 가능
            return N / 2;
        }
        else {
            return result.size(); // 아니라면 Map의 사이즈만큼만 가능
        }
    }
}