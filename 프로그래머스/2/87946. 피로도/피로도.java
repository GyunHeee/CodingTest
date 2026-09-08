import java.util.*;

class Solution {
    // 탐색문제 8!이 최대경우
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for (int i=0; i<dungeons.length; i++) {
            if (dungeons[i][0] > k) continue;
            
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, visited, count + 1);
            visited[i] = false;
        }
    }
}