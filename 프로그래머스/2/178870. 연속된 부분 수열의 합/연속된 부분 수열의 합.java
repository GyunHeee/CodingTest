import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int left = 0;
        long sum = 0;

        int answerLeft = 0;
        int answerRight = sequence.length - 1;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while (sum > k) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                int currentLength = right - left;
                int answerLength = answer[1] - answer[0];

                if (currentLength < answerLength) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        
        return answer;
    }
}