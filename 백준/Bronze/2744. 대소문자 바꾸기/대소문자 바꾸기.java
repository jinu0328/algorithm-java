import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();

        char[] words = input.toCharArray();

        for(int i = 0; i < words.length; i++) {
            if(Character.isUpperCase(words[i])) {
                words[i] = Character.toLowerCase(words[i]);
                continue;
            }
            
            words[i] = Character.toUpperCase(words[i]);
            
        }

        for(char word : words) {
            System.out.print(word);
        }

    }

}
