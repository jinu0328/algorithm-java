import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            if (current.value.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                String next = words[i];
                int diff = 0;

                for (int j = 0; j < next.length(); j++) {
                    if (current.value.charAt(j) != next.charAt(j)) {
                        diff++;
                    }
                }

                if (diff == 1) {
                    visited[i] = true;
                    queue.offer(new Word(next, current.depth + 1));
                }
            }
        }
        return 0;
    }
}

class Word {
    String value;
    int depth;
    
    Word(String value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}
