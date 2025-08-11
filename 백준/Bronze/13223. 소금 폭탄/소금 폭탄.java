import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String timeInput = scanner.nextLine();
        String goTimeInput = scanner.nextLine();

        String[] current = timeInput.split(":");
        String[] go = goTimeInput.split(":");

        int currentSec = toSeconds(current);
        int goSec = toSeconds(go);

        int diff = goSec - currentSec;
        if (diff <= 0) {
            diff += 24 * 3600;
        }

        int h = diff / 3600;
        int m = (diff % 3600) / 60;
        int s = diff % 60;

        System.out.printf("%02d:%02d:%02d", h, m, s);
    }

    private static int toSeconds(String[] time) {
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);

        return h * 3600 + m * 60 + s;
    }
}

