import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Map<String, Book> books = new HashMap<>();
        while(N-- > 0) {
            String name = br.readLine();
            if(books.containsKey(name)) {
                books.get(name).sell();
            }
            else {
                books.put(name, new Book(name));
            }
        }

        List<Book> values = new ArrayList<>(books.values().stream().collect(Collectors.toList()));

        values.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.count == o2.count) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.count - o1.count;
            }
        });

        System.out.println(values.get(0).name);


    }

    static class Book {
        int count = 0;
        String name;

        public Book(String name) {
            this.name = name;
        }

        void sell() {
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Book book = (Book) o;
            return Objects.equals(name, book.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

}