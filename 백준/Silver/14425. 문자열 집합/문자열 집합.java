import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> S = new HashSet<>();

        while(N-- > 0) {
            S.add(br.readLine());
        }

        int count = 0;
        while(M-- > 0) {
            if(S.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}