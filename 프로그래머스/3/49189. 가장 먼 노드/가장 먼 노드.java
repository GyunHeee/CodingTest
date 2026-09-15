import java.util.*;

class Solution {    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degrees = new int[n + 1];
        
        for (int i=0; i<= n ;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e: edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        queue.offer(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next: graph.get(cur)) {
                
                if (degrees[next] == 0) {
                    degrees[next] = degrees[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        int max = 0;
        for (int i=2; i<=n;i++) {
            max = Math.max(degrees[i], max);
        }
        
        for (int i=2; i<=n; i++) {
            if (max == degrees[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}