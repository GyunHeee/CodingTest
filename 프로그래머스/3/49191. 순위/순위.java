import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        int answer = 0;
        
        for (int i=0; i<n+1; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            int a = result[0];
            int b = result[1];
            
            winGraph.get(a).add(b);
            loseGraph.get(b).add(a);
        }
        
        for (int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int loseCnt = bfs(visited, loseGraph, i);
            int winCnt = bfs(visited, winGraph, i);
            
            if (loseCnt + winCnt == n + 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    int dfs(boolean[] visited, List<List<Integer>> graph, int cur) {
        int count = 1;
        
        visited[cur] = true;
        
        for (int next : graph.get(cur)) {
            if (visited[next]) continue;
            
            count += dfs(visited, graph, next);
        }
        
        return count;
    }
    
    int bfs(boolean[] visited, List<List<Integer>> graph, int begin) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        
        visited[begin] = true;
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : graph.get(cur)) {
                if (visited[next]) continue;
                
                visited[next] = true;
                count++;
                queue.offer(next);
            }
        }
        
        return count;
    }
}