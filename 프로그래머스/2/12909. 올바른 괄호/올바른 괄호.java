import java.util.Stack;

class Solution {
    boolean solution(String s) {
        int remains = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while(!stack.empty()) {
            if(stack.pop() == ')') {
                remains++;
            }
            else {
                remains--;
            }

            if(remains < 0) {
                return false;
            }
        }

        return remains == 0;


    }
}