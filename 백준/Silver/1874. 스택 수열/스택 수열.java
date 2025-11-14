import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> stack = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int next = 1;
        while(n-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if(next <= target) {
                for(int i = next; i <= target; i++) {
                    stack.add(i);
                    sb.append("+\n");
                }
                next = target + 1;
                stack.remove(stack.size() - 1);
                sb.append("-\n");
            }
            else {
                int current = stack.remove(stack.size() - 1);
                if(current == target) {
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb.toString());
    }
}