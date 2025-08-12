import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];
        for(int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1; i <= 10000; i++) {
            while (nums[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
