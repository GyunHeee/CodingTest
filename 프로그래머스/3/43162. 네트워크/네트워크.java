import java.util.*;

class Solution {    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n + 1];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(computers, i ,visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int[][] computers, int cur, boolean[] visited) {
        visited[cur] = true;
        
        for (int i=0; i<computers[cur].length; i++) {
            if (visited[i]) continue;
            if (computers[cur][i] == 0) continue;
            if (cur == i) continue;
        
            dfs(computers, i, visited);
        }
    }
}