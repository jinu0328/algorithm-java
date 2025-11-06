import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int student1 = 0;
        int student2 = 0;
        int student3 = 0;
        
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answer1[i % answer1.length] == answers[i]) {
                student1++;
            }
            if(answer2[i % answer2.length] == answers[i]) {
                student2++;
            }
            if(answer3[i % answer3.length] == answers[i]) {
                student3++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int max = Math.max(student1, Math.max(student2, student3));
        if(student1 == max) {
            result.add(1);
        }
        if(student2 == max) {
            result.add(2);
        }
        if(student3 == max) {
            result.add(3);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}