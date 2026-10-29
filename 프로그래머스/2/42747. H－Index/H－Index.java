import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i=0; i<citations.length; i++) {
            System.out.println(citations[i]);
            int citation = citations[i];
            int h = citations.length - i;
            
            if (citation >= h) {
                answer = h;
                return answer;
            }
        }
        
        return 0;
    }
}