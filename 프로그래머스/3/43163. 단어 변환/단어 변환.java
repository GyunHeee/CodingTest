import java.util.*;

class Solution {
    
    static class Node {
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
            Node cur = queue.poll();
            
            if (cur.word.equals(target)) {
                return cur.depth;
            }
            
            for (int i=0; i<words.length; i++) {
                if (visited[i]) continue;
                int diff = 0;
                
                for (int j=0; j<cur.word.length(); j++) {
                    if (words[i].charAt(j) != cur.word.charAt(j)) diff++;
                }
                
                if (diff == 1) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], cur.depth + 1));
                }
            }
        }
        
        return 0;
    }
}