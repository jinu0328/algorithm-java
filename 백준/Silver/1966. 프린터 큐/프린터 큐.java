import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 수

        while (T-- > 0) {
            int N = sc.nextInt(); // 문서 수
            int M = sc.nextInt(); // 궁금한 문서의 위치
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

                // 큐에 남아 있는 문서 중 우선순위가 높은 문서가 있는지 확인
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
        sc.close();
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
