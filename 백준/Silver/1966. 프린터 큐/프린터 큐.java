import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[N];

            for (int i = 0; i < N; i++) {
                int p = sc.nextInt();
                queue.add(new Document(i, p));
                priorities[i] = p;
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                Document doc = queue.poll();
                boolean hasHigher = false;

                for (Document d : queue) {
                    if (d.priority > doc.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(doc);
                } else {
                    printOrder++;
                    if (doc.index == M) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
    
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
