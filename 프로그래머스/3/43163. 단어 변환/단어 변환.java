import java.util.*;

class Solution {
    
    public class Node {
        String word;
        int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length + 1];
        return bfs(begin, target, words, visited);
    }
    
    int bfs(String begin, String target, String[] words, boolean[] visited) {
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(new Node(begin, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) return current.depth;
            
            for (int i=0; i<words.length; i++) {
                int diff = 0;
                for (int k=0; k<words[i].length(); k++) {
                    if (words[i].charAt(k) != current.word.charAt(k)) {
                        diff++;
                    }
                }
                
                if (diff == 1) {
                    if (visited[i]) continue;
                    
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.depth + 1));
                }
            }    
        }
        
        return 0;
    }
}