import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       int N = scanner.nextInt();
       int M = scanner.nextInt();
       scanner.nextLine();
       char[][] tower = new char[N][M];

       for(int i = 0; i < tower.length; i++) {
           tower[i] = scanner.nextLine().toCharArray();
       }

       boolean[] rowNeed = new boolean[M];
       boolean[] columnNeed = new boolean[N];
       int rowCount = 0;
       int columnCount = 0;

       for(int i = 0; i < N; i++) {
           for(int j = 0; j < M; j++) {
               if(tower[i][j] == 'X') {
                   columnNeed[i] = true;
                   rowNeed[j] = true;
               }
           }
       }

       for(int i = 0; i < N; i++) {
           if(!columnNeed[i]) {
               columnCount++;
           }
       }

        for(int i = 0; i < M; i++) {
            if(!rowNeed[i]) {
                rowCount++;
            }
        }

        System.out.printf("%d", Math.max(rowCount, columnCount));



    }
}
