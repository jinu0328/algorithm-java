import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String word = scanner.nextLine();

        int[] count = new int[26];

        for(int i = 0 ; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                count[word.charAt(i) - 'A']++;
                continue;
            }
            count[word.charAt(i) - 'a']++;
        }

        int max = 0;
        for(int i = 1; i < 26; i++) {
            if(count[max] < count[i]) {
                max = i;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(max != i && count[max] == count[i]) {
                System.out.println("?");
                return;
            }
        }

        System.out.println((char) ('A' + max));

    }
}
