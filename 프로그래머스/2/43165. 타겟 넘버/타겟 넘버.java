class Solution {
    boolean[] visited;
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return count;
    }
    
    private void dfs(int current, int next, int target, int[] numbers) {
        if(next == numbers.length) {
            if(current == target) {
                count++;
            }
            return;
        }
        
        dfs(current + numbers[next], next + 1, target, numbers);
        dfs(current - numbers[next], next + 1, target, numbers);
    }
}
