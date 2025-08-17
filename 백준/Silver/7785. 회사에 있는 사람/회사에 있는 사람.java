import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       int n = Integer.parseInt(br.readLine());


       Set<String> people = new HashSet<>();
       for(int i = 0; i < n; i++) {
           String[] input = br.readLine().split(" ");
           String person = input[0];
           String command = input[1];

           if(Objects.equals(command, "enter")) {
               people.add(person);
           }
           else {
               people.remove(person);
           }

       }

       List<String> result = new ArrayList<>(people);
       result.sort(Comparator.reverseOrder());

       for(int i = 0; i < result.size(); i++) {
           bw.write(result.get(i) + "\n");
       }

       bw.flush();
    }

}