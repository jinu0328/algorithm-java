import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] hotel;
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            if(N % H == 0) {
                y = H;
            } else {
                y = N % H;
            }

            if(N % H == 0) {
                x = N / H;
            } else {
                x = N / H + 1;
            }

            System.out.printf("%d%02d\n", y, x);
        }
    }
}
