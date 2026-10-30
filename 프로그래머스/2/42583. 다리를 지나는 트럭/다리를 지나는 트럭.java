import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        
        for (int i=0; i<truck_weights.length; i++) {
            waiting.offer(truck_weights[i]);
        }
        
        int currentWeight = 0;
        
        while (!waiting.isEmpty() || currentWeight > 0) {
            
            answer++;
            
            if (bridge_length == bridge.size()) {
                currentWeight -= bridge.poll();
            }
            
            if (!waiting.isEmpty() && currentWeight + waiting.peek() <= weight) {
                int item = waiting.poll();
                bridge.offer(item);
                currentWeight += item;
            } else {
                bridge.offer(0);
            }
        }
        
        return answer;
    }
}