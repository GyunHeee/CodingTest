import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {    
        int left = 1;
        int right = 1;
        
        for (int diff : diffs) {
            right = Math.max(diff, right);
        }
        
        int answer = right;
        
        while (left <= right) {
            int answer_mid = (left + right) / 2;
            long time = 0;
            
            for (int i=0; i<diffs.length; i++) {
                if (i == 0) {
                    if (diffs[i] <= answer_mid) {
                        time += times[i];
                    } else {
                        int diff = diffs[i] - answer_mid;
                        time += diff * times[i] + times[i];
                    }
                } else {
                    if (diffs[i] <= answer_mid) {
                        time += times[i];
                    } else {
                        int diff = diffs[i] - answer_mid;
                        time += diff * (times[i-1] + times[i]) + times[i];
                    }
                }
            }
            
            if (limit >= time) {
                answer = answer_mid;
                right = answer_mid - 1;
            } else {
                left = answer_mid + 1;
            }
        }
        
        return answer;
    }
}