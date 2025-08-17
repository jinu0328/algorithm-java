import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       int N = Integer.parseInt(br.readLine());
       Person[] people = new Person[N];

       for(int i = 0; i < N; i++) {
           String[] input = br.readLine().split(" ");
           int age = Integer.parseInt(input[0]);
           String name = input[1];
           people[i] = new Person(age, name);
       }

       Arrays.sort(people);

       for(int i = 0; i < N; i++) {
           bw.write(people[i].age + " " + people[i].name + "\n");
       }

       bw.flush();

    }

    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return age - o.age;
        }
    }
}