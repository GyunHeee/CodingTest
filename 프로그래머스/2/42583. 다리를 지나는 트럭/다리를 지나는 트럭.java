import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        
        int currentWeight = 0;
        
        for (int i=0; i < truck_weights.length; i++) {
            waiting.offer(truck_weights[i]);
        }
        
        while (!waiting.isEmpty() || currentWeight > 0) {
            answer++;
            
            if (bridge.size() == bridge_length) {
                currentWeight -= bridge.poll();
            }
            
            if (!waiting.isEmpty() && currentWeight + waiting.peek() <= weight) {
                int truck = waiting.poll();
                bridge.offer(truck);
                currentWeight += truck;
            } else {
                bridge.offer(0);
            }
        }
        
        
        return answer;
    }
}