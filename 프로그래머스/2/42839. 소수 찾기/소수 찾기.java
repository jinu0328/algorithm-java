import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        generateNumber("", numbers, numberSet, visited);

        int count = 0;
        for(int num : numberSet) {
            if(isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void generateNumber(String current, String numbers, Set<Integer> numberSet, boolean[] visited) {
        if(current != "") {
            numberSet.add(Integer.parseInt(current));
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                generateNumber(current + numbers.charAt(i), numbers, numberSet, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }

        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
