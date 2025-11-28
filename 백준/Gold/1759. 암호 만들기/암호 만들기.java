import java.util.*;
import java.io.*;

public class Main {

    static int L, C;
    static char[] password;
    static char[] input;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        password = new char[L];
        input = new char[C];
        for (int i = 0; i < C; i++) {
            input[i] = sc.next().charAt(0);
        }

        Arrays.sort(input);
        solve(0, 0, 0);
    }

    private static void solve(int length, int index, int count) {
        if(length == L) {
            if(count >= 1 && length - count >= 2) {
                System.out.println(password);
            }
            return;
        }

        if(index < C) {
            password[length] = input[index];
            int v = is(input[index]) ? 1 : 0;
            solve(length + 1, index + 1, count + v);
            solve(length, index + 1, count);
        }

    }

    private static boolean is(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
