import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int currentX = (x + t) % (2 * w);
        if (currentX > w) {
            currentX = 2 * w - currentX;
        }

        int currentY = (y + t) % (2 * h);
        if (currentY > h) {
            currentY = 2 * h - currentY;
        }

        System.out.println(currentX + " " + currentY);
    }
}
