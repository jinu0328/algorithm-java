import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       int N = Integer.parseInt(br.readLine());
       List<Meeting> meetings = new ArrayList<>();
       for(int i = 0; i < N; i++) {
           String[] input = br.readLine().split(" ");
           meetings.add(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
       }

       meetings.sort(new Comparator<Meeting>() {
           @Override
           public int compare(Meeting o1, Meeting o2) {
               if(o1.end == o2.end) {
                   return o1.start - o2.start;
               }
               return o1.end - o2.end;
           }
       });

       int currentEnd = 0;
       int count = 0;
       for(int i = 0; i < N; i++) {
           Meeting meeting = meetings.get(i);
           if(meeting.start >= currentEnd) {
               count++;
               currentEnd = meeting.end;
           }
       }

        System.out.println(count);


    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}