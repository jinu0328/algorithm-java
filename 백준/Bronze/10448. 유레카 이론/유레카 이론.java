import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int check = 0;
            for(int i = 1; i <= 44; i++) {
                for(int j = 1; j <= 44; j++) {
                    for(int k = 1; k <= 44; k++) {
                        if (getEureka(i) + getEureka(j) + getEureka(k) == K) {
                            check = 1;
                            break;
                        }
                    }
                }
            }
            bw.write(check + "\n");
        }
        bw.flush();
    }

    private static int getEureka(int n) {
        return n * (n + 1) / 2; // 44까지 가능
    }
}
