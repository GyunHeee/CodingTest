import java.util.*;

class Solution {
    
    int answer = 100000;
    boolean isFound = false;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        if (!isFound) {
            answer = 0;
        }
        return answer;
    }
    
    // 백트레킹 문제인데
    void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            isFound = true;
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            int diff = 0;
            
            for (int j=0; j<begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }
            
            if (diff == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}