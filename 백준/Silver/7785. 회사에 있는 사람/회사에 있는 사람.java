import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> people = new HashSet<>();
        while(n-- > 0) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String action = input[1];

            if(Objects.equals(action, "enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }

        people.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                })
                .forEach(name -> {
                    try {
                        bw.write(name + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        bw.flush();
    }
}
