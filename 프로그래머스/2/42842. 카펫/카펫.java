import java.util.*;

class Solution {
    public List<Integer> solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();

        for (int i=1; i<= yellow; i++) {
            if (yellow % i ==0) {
                int j = yellow / i;
                
                if ((j + 2) * (i + 2) == yellow + brown) {
                    answer.add(j + 2);
                    answer.add(i + 2);
                    return answer;
                }
            }
        }
        
        return answer;
    }
}