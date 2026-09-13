import java.util.*;

class Solution {    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degrees = new int[edge.length + 1];
        
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        
        queue.offer(1);
        degrees[1] = 0;
        int currentDegree = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int g : graph.get(node)) {
                if (degrees[g] == 0) {
                    degrees[g] = degrees[node] + 1;
                    queue.offer(g);
                }
            }
        }
        
        int max = 0;
        for (int i=2; i<degrees.length; i++) {
            max = Math.max(max, degrees[i]);
        }
        
        for (int i=2; i<degrees.length; i++) {
            if (max == degrees[i]) answer++;
        }
        
        return answer;
    }
}