public class Solution {
    private static final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        int[] weights = {781, 156, 31, 6, 1}; 
        
        for (int i = 0; i < word.length(); i++) {
            int idx = getIndex(word.charAt(i));
            answer += idx * weights[i] + 1;
        }
        return answer;
    }
    
    private int getIndex(char c) {
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return i;
            }
        }
        return 0; 
    }
}
