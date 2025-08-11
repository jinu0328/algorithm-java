import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < word2.length(); i++) {
            count2[word2.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            count += Math.abs(count1[i] - count2[i]);
        }

        System.out.println(count);

    }
}
