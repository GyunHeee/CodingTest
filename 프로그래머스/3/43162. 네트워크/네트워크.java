import java.util.*;

class Solution {    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
    
        for (int i=0; i<computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);  
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int cur, int[][] computers, boolean[] visited) {
        
        for (int i=0; i<computers[cur].length; i++) {
            
            if (i == cur) continue;
            if (visited[i]) continue;
            if (computers[cur][i] == 0) continue;
            
            visited[i] = true;
            dfs(i, computers, visited);
        }
    }
}