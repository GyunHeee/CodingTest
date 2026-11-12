import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 99999;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i=0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            
            int a = wire[0];
            int b = wire[1];
        
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int countA = dfs(a, graph, visited);
            int countB = n - countA;
            int diff = Math.abs(countA - countB);
            answer = Math.min(diff, answer);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    int dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        int count = 1;
        
        visited[cur] = true;
        
        for (int next: graph.get(cur)) {
            if (visited[next]) continue;
            
            visited[next] = true;
            count += dfs(next, graph, visited);
        }
        
        return count;
    }
}