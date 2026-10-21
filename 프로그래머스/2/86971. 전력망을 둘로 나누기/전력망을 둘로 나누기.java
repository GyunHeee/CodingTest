import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        int answer = n;
        
        for (int i=0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n + 1];
            int countA = dfs(graph, a, visited);
            int countB = n - countA;
            
            int diff = Math.abs(countA - countB);
            answer = Math.min(answer, diff);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    int dfs(List<List<Integer>> graph, int cur, boolean[] visited) {
        int count = 1;
        
        visited[cur] = true;
        
        for (int next: graph.get(cur)) {
            if (visited[next]) continue;
            
            count += dfs(graph, next, visited);
        }
        
        return count;
    }
}