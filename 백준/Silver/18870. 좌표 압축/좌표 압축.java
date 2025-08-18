import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        X[] values = new X[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            values[i] = new X(Integer.parseInt(input[i]));
        }

        X[] copy = new X[N];
        for(int i = 0; i < N; i++) {
            copy[i] = values[i];
        }

        Arrays.sort(copy, new Comparator<X>() {
            @Override
            public int compare(X o1, X o2) {
                return o1.value - o2.value;
            }
        });

        int current = 0;
        int originValue = copy[0].value;
        copy[0].setValue(0);
        for(int i = 1; i < N; i++) {
            if(originValue == copy[i].value) {
                copy[i].setValue(current);
            }
            else {
                current++;
                originValue = copy[i].value;
                copy[i].setValue(current);
            }
        }

        for(int i = 0; i < N; i++) {
            bw.write(values[i].value + " ");
        }
        bw.flush();




    }

    static class X {
        int value;

        public X(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}