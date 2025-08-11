import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String document = scanner.nextLine();
        String word = scanner.nextLine();

        int i = 0;
        int count = 0;
        while (true) {
            int index = document.indexOf(word, i);
            if(index >= 0) {
                count++;
                i = index + word.length();
            }
            else break;
        }

        System.out.println(count);
    }
}
