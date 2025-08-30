import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> deck = new HashMap<>();
        String[] input1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int key = Integer.parseInt(input1[i]);
            deck.put(key, deck.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            bw.write(deck.getOrDefault(Integer.parseInt(input2[i]), 0) + " ");
        }

        bw.flush();

    }
}
