import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        char[] word1 = input1.toCharArray();
        char[] word2 = input2.toCharArray();

        for(int i = 0; i < input1.length(); i++) {
            for(int j = 0; j < input2.length(); j++) {
                if(word2[j] == word1[i]) {
                    word1[i] = '@';
                    word2[j] = '@';
                    break;
                }
            }
        }
        int count = 0;
        for(char c : word1) {
            if(c != '@') {
                count++;
            }
        }

        for(char c : word2) {
            if(c != '@') {
                count++;
            }
        }

        System.out.println(count);


    }
}
