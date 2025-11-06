import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 논문 n편 중 h번 이상 인용된 논문이 h편 이상
        // 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
        
        // 0 2 5 6
        Arrays.sort(citations);
        int h = 0;
        for(int i = 0; i < citations.length; i++) {
            int num = citations.length - i;
            if(citations[i] >= num) {
                h = num;
                break;
            }
        }
        
        return h;
    }
}