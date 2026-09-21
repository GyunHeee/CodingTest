import java.util.*;

class Solution {
    // 탐색문제 8!이 최대경우
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length + 1];
        dfs(visited, dungeons, k, 0);
        
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] dungeons, int k, int count) {
        
        answer = Math.max(answer, count);
        
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(visited, dungeons, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}