import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        K = sc.nextInt();

        List<Integer> people = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            people.add(i);
        }

        int removeIndex = K - 1;
        int count = 0;
        int[] removed = new int[N];

        while(!people.isEmpty()) {
            removeIndex = removeIndex % people.size();
            Integer person = people.remove(removeIndex);
            removed[count++] = person;
            removeIndex += K - 1;
        }


        bw.write("<");
        for(int i = 0; i < N; i++) {
            if(i == N - 1) {
                bw.write(removed[i] + "");
                break;
            }
            bw.write(removed[i] + ", ");
        }
        bw.write(">");
        bw.flush();

    }
}
