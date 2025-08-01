import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        // Step 1. 숫자 배열을 문자열 배열로 변환
        String[] nums = Arrays.stream(numbers)
                              .mapToObj(String::valueOf)
                              .toArray(String[]::new);

        // Step 2. 정렬: (b + a)와 (a + b)를 비교해서 더 큰 쪽을 앞에 오도록
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // Step 3. 모두 0이면 "0" 반환
        if (nums[0].equals("0")) {
            return "0";
        }

        // Step 4. 이어붙이기
        return String.join("", nums);
    }
}
