class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target, 0);
        return answer;
    }
    
    private void dfs(int index, int initial, int[] numbers, int target, int count) {
        if(initial == target && count == numbers.length) {
            answer++;
            return;
        }
        for(int i = index; i < numbers.length; i++) {
            dfs(i + 1, initial + numbers[i], numbers, target, count + 1);
            dfs(i + 1, initial - numbers[i], numbers, target, count + 1);
        }
    }
}