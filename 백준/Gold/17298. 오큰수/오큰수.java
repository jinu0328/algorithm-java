import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        // O(N)
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(nums[nums.length - 1]);
        result[result.length - 1] = -1;

        // O(N)
        for(int i = nums.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                stack.pollLast();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.add(nums[i]);
        }

        for(int number : result) {
            bw.write(number + " ");
        }
        
        bw.flush();
    }
}
