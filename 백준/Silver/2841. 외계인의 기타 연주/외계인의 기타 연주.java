import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

       int N = sc.nextInt();
       int P = sc.nextInt();

       Map<Integer, List<Integer>> map = new HashMap<>();

       while(N-- > 0) {
           int n = sc.nextInt();
           int p = sc.nextInt();

           List<Integer> stack = map.getOrDefault(n, new ArrayList<>());

           if(stack.isEmpty()) {
               stack.add(p);
               result++;
               map.put(n, stack);
               continue;
           }

           if(stack.get(stack.size() - 1) == p) {
               map.put(n, stack);
               continue;
           }

           while(true) {
               if(stack.isEmpty()) {
                   stack.add(p);
                   result++;
                   break;
               }
               if(stack.get(stack.size() - 1) > p) {
                   stack.remove(stack.size() - 1);
                   result++;
               }
               else if(stack.get(stack.size() - 1) == p) {
                   break;
               }
               else {
                   stack.add(p);
                   result++;
                   break;
               }
           }

           map.put(n, stack);
       }

        System.out.println(result);
    }
}