import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(br.readLine());

        int count = 0;
        int[] counts = new int[1000001];
        for(int i = 0; i < n; i++) {
            counts[nums[i]] = 1;
        }

        for(int i = 0; i < n; i++) {
            int diff = x - nums[i];
            if(diff < 1 || diff > 1000000) {
                continue;
            }
            
            if(counts[diff] != 0) {
                count++;
            }
        }
        bw.write(count/2 + "\n");
        bw.flush();
    }
}
