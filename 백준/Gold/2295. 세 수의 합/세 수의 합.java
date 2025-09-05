import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] U;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Set<Integer> U = new HashSet<>();

        for(int i = 0; i < N; i++) {
            U.add(Integer.parseInt(br.readLine()));
        }

        Set<Integer> target = new HashSet<>();
        int index = 0;
        for(int num1 : U) {
            for(int num2 : U) {
                target.add(num1 + num2);
            }
        }

        int result = 0;
        for(int num1 : U) {
            for(int num2 : U) {
                if(target.contains(num1 - num2)) {
                    result = Math.max(result, num1);
                }
            }
        }

        System.out.println(result);
    }
}
