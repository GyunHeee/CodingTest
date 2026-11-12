import java.util.*;

class Solution {
    // 탐색문제 8!이 최대경우
    
    int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(visited, dungeons, k, 0);
  
        return maxCount;
    }

    void dfs(boolean[] visited, int[][] dungeons, int k, int count) {
        maxCount = Math.max(count, maxCount);
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] > k) continue;
            
            visited[i] = true;
            dfs(visited, dungeons, k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}