import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean isHigher = false;
            
            for (int[] item : queue) {
                if (item[1] > current[1]) {
                    isHigher = true;
                    queue.offer(current);
                    break;
                }
            }
            
            if (!isHigher) {
                answer++;
                
                if (current[0] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}