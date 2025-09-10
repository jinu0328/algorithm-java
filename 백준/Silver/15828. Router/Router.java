import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> router = new ArrayDeque<>();

        int n = 0;
        while(n >= 0) {
            n = Integer.parseInt(br.readLine());
            if(n > 0) {
                if(router.size() == N) {
                    continue;
                }
                router.add(n);
            } else if(n < 0) {
                break;
            } else {
                router.poll();
            }
        }

        if(router.isEmpty()) {
            System.out.println("empty");
            return;
        }

        for(int packet : router) {
            bw.write(packet + " ");
        }
        bw.flush();
    }
}
