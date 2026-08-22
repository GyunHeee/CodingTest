import java.util.*;

class Solution {
    int answer = -1;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);

        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int count) {
        
        answer = Math.max(count, answer);
        
        for (int i=0; i<dungeons.length; i++) {
            if (dungeons[i][0] <= k && !visited[i]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}