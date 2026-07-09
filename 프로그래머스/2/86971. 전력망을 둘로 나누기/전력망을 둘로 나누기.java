import java.util.*;

class Solution {   
    
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        
        int answer = 1000;
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int[] wire: wires) {
            visited = new boolean[n + 1];
            int cutA = wire[0];
            int cutB = wire[1];
            
            int cnt = dfs(cutA, cutA,cutB, graph);
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    int dfs(int cur, int cutA, int cutB, ArrayList<Integer>[] graph) {
        int count = 1;
        visited[cur] = true;
        
        for (int next: graph[cur]) {
            if (cur == cutA && next == cutB ||
               next == cutA && cur == cutB) {
                continue;
            }
            
            if (!visited[next]) {
                count += dfs(next, cutA, cutB, graph);
            }
        }
        
        return count;
    }
}