import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<List<Integer>> wins = new ArrayList<>();
        List<List<Integer>> loses = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            wins.add(new ArrayList<>());
            loses.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            wins.get(winner).add(loser);
            loses.get(loser).add(winner);
        }
        
        for (int i=1; i<=n; i++) {
            int winCount = dfs(i, new boolean[n + 1], wins) - 1;
            int loseCount = dfs(i, new boolean[n + 1], loses) - 1;
            
            if (winCount + loseCount == n - 1) {
                answer++;
            }
            
            // System.out.println(winCount + " " + loseCount);
        }
        
        return answer;
    }
    
    int dfs(int cur, boolean[] visited, List<List<Integer>> graph) {
        visited[cur] = true;
        int count = 1;
        
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(next, visited, graph);
            }
        }
        
        return count;
    }
}