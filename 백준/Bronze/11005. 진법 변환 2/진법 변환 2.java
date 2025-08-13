import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        // B진수 변환 결과를 담을 StringBuilder
        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            sb.append('0');
        } else {
            while (N > 0) {
                int remainder = N % B; // 나머지
                if (remainder < 10) {
                    sb.append(remainder); // 0~9
                } else {
                    sb.append((char) ('A' + remainder - 10)); // 10~15 -> A~F
                }
                N /= B;
            }
        }

        // 뒤에서부터 쌓였으므로 뒤집기
        bw.write(sb.reverse().toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
