import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Staff> staffs = new ArrayList<>();

        while(N-- > 0) {
            String[] input = br.readLine().split(" ");
            int vote = Integer.parseInt(input[1]);
            if(vote * 20 >= X) {
                staffs.add(new Staff(input[0].charAt(0), vote));
            }
        }

        Score[] scores = new Score[14 * staffs.size()];
        int i = 0;
        for(Staff staff : staffs) {
            scores[i++] = new Score(staff.name, staff.vote);
            scores[i++] = new Score(staff.name, staff.vote / 2);
            scores[i++] = new Score(staff.name, staff.vote / 3);
            scores[i++] = new Score(staff.name, staff.vote / 4);
            scores[i++] = new Score(staff.name, staff.vote / 5);
            scores[i++] = new Score(staff.name, staff.vote / 6);
            scores[i++] = new Score(staff.name, staff.vote / 7);
            scores[i++] = new Score(staff.name, staff.vote / 8);
            scores[i++] = new Score(staff.name, staff.vote / 9);
            scores[i++] = new Score(staff.name, staff.vote / 10);
            scores[i++] = new Score(staff.name, staff.vote / 11);
            scores[i++] = new Score(staff.name, staff.vote / 12);
            scores[i++] = new Score(staff.name, staff.vote / 13);
            scores[i++] = new Score(staff.name, staff.vote / 14);
        }

        Arrays.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.score - o1.score;
            }
        });

        for(int k = 0; k < 14; k++) {
            Score score = scores[k];
            Staff staff = staffs.stream()
                    .filter(staff1 -> staff1.name == score.name)
                    .findAny()
                    .get();
            staff.plus();
        }

        staffs.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.name - o2.name;
            }
        });

        for(Staff staff : staffs) {
            bw.write(staff.name + " " + staff.coin + "\n");
        }

        bw.flush();

    }

    static class Score {
        char name;
        int score;

        public Score(char name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Staff {
        char name;
        int vote;
        int coin = 0;

        public Staff(char name, int vote) {
            this.name = name;
            this.vote = vote;
        }

        void plus() {
            coin++;
        }
    }
}