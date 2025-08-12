import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int P = scanner.nextInt();

        for (int i = 1; i <= P; i++) {
            int T = scanner.nextInt();
            int[] students = new int[20];
            for (int j = 0; j < 20; j++) {
                students[j] = scanner.nextInt();
            }

            int[] line = new int[20];

            int lastIndex = 0;
            int count = 0;
            for(int j = 0; j < 20; j++) {
                int current = lastIndex;
                line[lastIndex++] = students[j];

                while(current > 0) {
                    if(line[current] < line[current - 1]) {
                        int tmp = line[current];
                        line[current] = line[current - 1];
                        line[current - 1] = tmp;
                        count++;
                        current = current - 1;
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.printf("%d %d\n", T, count);

        }
    }
}
