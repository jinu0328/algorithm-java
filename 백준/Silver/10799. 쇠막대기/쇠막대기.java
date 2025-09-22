import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char prev = ' ';
        
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                stack.pop();
                if (prev == '(') {
                    // 레이저: 현재 열린 막대기 개수만큼 조각 추가
                    result += stack.size();
                } else {
                    // 막대기 끝: 한 조각 추가
                    result += 1;
                }
            }
            prev = c;
        }
        
        System.out.println(result);
    }
}
