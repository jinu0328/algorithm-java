import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] nums = new int[N + 1];
        String[] input2 = ("0 " + br.readLine()).split(" ");
        for(int i = 0; i <= N; i++) {
            nums[i] = Integer.parseInt(input2[i]);
        }

        int[] acc = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + nums[i];
        }

        int i = 1;
        int j = 1;
        int result = Integer.MAX_VALUE;
        while(i <= N && j <= N) {
            int sum = acc[j] - acc[i - 1];
            if(sum == S) {
                result = Math.min(result, j - i + 1);
                i++; j++;
            }
            else if (sum < S) {
                j++;
            }
            else {
                result = Math.min(result, j - i + 1);
                i++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
