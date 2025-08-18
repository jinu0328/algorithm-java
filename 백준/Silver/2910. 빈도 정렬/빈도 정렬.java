import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);

        List<Number> numbers = new ArrayList<>();
        String[] input2 = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(input2[i]);
            if(numbers.contains(new Number(value))) {
                Number number = null;
                for(int j = 0; j < numbers.size(); j++) {
                    if(numbers.get(j).equals(new Number(value))) {
                        number = numbers.get(j);
                        break;
                    }
                }
                number.up();
            }
            else {
                numbers.add(new Number(value));
            }
        }

        numbers.sort(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o2.count - o1.count;
            }
        });

        for(Number number : numbers) {
            for(int i = 0; i < number.count; i++) {
                bw.write(number.value + " ");
            }
        }

        bw.flush();
    }

    static class Number {
        int value;
        int count = 1;

        public Number(int value) {
            this.value = value;
        }

        void up() {
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Number number = (Number) o;
            return value == number.value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }
    }
}