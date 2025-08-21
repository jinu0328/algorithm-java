import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] nums;
    static int x;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        x = Integer.parseInt(br.readLine());

        int count = 0;
        int[] real = new int[2000000];

        for(int i = 0; i < n; i++) {
            real[nums[i]] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(x - nums[i] < 0) {
                continue;
            }
            if(real[x - nums[i]] == 1) {
                count++;
            }

        }

        System.out.println(count/2);
    }
}
