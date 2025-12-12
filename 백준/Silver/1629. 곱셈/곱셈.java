import java.util.Scanner;

public class Main {
    static long a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // A를 B번 곱한수를 C로 나눈 나머지
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(power(a, b));
    }

    static long power(long a, long b) {
        if(b == 1) {
            return a % c;
        }

        long half = power(a, b/2);
        if(b % 2 == 0) {
            return (half * half) % c;
        }
        else {
            return (((half * half) % c) * a) % c;
        }
    }


}
