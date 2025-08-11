import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String word = scanner.nextLine();

        for(int i = 0; i < word.length(); i++) {
            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                System.out.print((char) ('a' + word.charAt(i) - 'A'));
                continue;
            }
            System.out.print((char) ('A' + word.charAt(i) - 'a'));
        }

    }

}
