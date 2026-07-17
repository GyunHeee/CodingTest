import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }        
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        int[] distance = new int[y + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;
        
        queue.offer(x);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            int[] nextNumbers = {
                current + n,
                current * 2,
                current * 3
            };
            
            for (int next : nextNumbers) {
                
                if (next > y || distance[next] != -1) {
                    continue;
                }
                
                distance[next] = distance[current] + 1;
                
                if (next == y) {
                    return distance[next];
                }
                
                queue.offer(next);
            }
        }
        
        return -1;
    }
}