import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static String[] S;
    static String[] input;
    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        S = new String[N];
        input = new String[M];

        for(int i = 0; i < N; i++) {
            S[i] = sc.nextLine();
        }

        for(int i = 0; i < M; i++) {
            input[i] = sc.nextLine();
        }

        int count = 0;
        Arrays.sort(S);
        for(int i = 0; i < M; i++) {
            if(Arrays.binarySearch(S, input[i]) < 0) {
                continue;
            }
            count++;
        }

        System.out.println(count);
    }
}