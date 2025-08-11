import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[] document = scanner.nextLine().toCharArray();
        char[] word = scanner.nextLine().toCharArray();
        int count = 0;

        for(int i = 0; i < document.length; i++) {
            if(document[i] == word[0]) {
                int originI = i;
                boolean matched = true;
                for(int j = originI + 1; j < originI + word.length; j++) {
                    i++;
                    if(j >= document.length) {
                        matched = false;
                        break;
                    }
                    if(document[j] != word[j - originI]) {
                        matched = false;
                        break;
                    }
                }
                if(matched) {
                    count++;
                }
                else {
                    i = originI;
                }
            }
        }

        System.out.println(count);

    }
}
