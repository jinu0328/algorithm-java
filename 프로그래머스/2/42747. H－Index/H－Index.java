import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int max = Arrays.stream(citations)
                .max().getAsInt();
        int result = 0;
        for(int i = 0; i <= max; i++) {
            int current = i;
            // n편 중 h번 이상 인용된 논문이 h편 이상
            long count = Arrays.stream(citations)
                    .filter(citation -> citation >= current)
                    .count();
            if(current <= count) {
                result = current;
            }
        }
        
        return result;
    }
//
//    static class Document {
//        int count;
//        boolean isChecked = false;
//
//        public Document(int count) {
//            this.count = count;
//        }
//
//        public void check() {
//            isChecked = true;
//        }
//    }
}
