import java.util.*;

class Solution {    
    int maxDistance = 0;
    
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        int answer = 0;
        
        for (int i=0; i<edge.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs(1, graph, visited, distance);
        for (int i=0; i<distance.length; i++) {
            if (distance[i] == maxDistance) answer++;
        }
        
        return answer;
    }
    
    void bfs(int begin, List<List<Integer>> graph, boolean[] visited, int[] distance) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        visited[begin] = true;
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (visited[next]) continue;
                
                visited[next] = true;
                queue.offer(next);
                
                distance[next] = distance[current] + 1;
                maxDistance = Math.max(maxDistance, distance[next]);
            }
        }
    }
}