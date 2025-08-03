import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        generateNumbers("", numbers, visited, numberSet);

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void generateNumbers(String current, String numbers, boolean[] visited, Set<Integer> set) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(current + numbers.charAt(i), numbers, visited, set);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
