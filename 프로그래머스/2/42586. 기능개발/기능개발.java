import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> complete = new ArrayList<>();
        
        for (int i=0; i<progresses.length; i++) {
            
            int cnt = 0;
            
            while (progresses[i] < 100) {
                cnt++;
                
                progresses[i] += speeds[i];
            }
            
            complete.add(cnt);
        }
        
        for (int i=0; i<complete.size() - 1; i++) {
            if (complete.get(i) > complete.get(i+1)) {
                complete.set(i + 1, complete.get(i));
            }
        }
        
        for (int i=0; i<complete.size() - 1; i++) {
            if (complete.get(i) == complete.get(i+1)) {
                
            }
        }
        
        int count = 1;

        for (int i = 1; i < complete.size(); i++) {
            if (complete.get(i).equals(complete.get(i - 1))) {
                count++;
            } else {
                answer.add(count);
                count = 1;
            }
        }
        
        answer.add(count);

        
        return answer;
    }
}