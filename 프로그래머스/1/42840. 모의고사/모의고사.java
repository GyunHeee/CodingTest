import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        
        List<Integer> answer = new ArrayList<>();
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        int std1Cnt = 0;
        int std2Cnt = 0;
        int std3Cnt = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) std1Cnt++;
            if (answers[i] == student2[i % student2.length]) std2Cnt++;
            if (answers[i] == student3[i % student3.length]) std3Cnt++;
        }
        
        int max = 0;
        max = Math.max(Math.max(std1Cnt, std2Cnt), std3Cnt);
        
        if (max == std1Cnt) answer.add(1);
        if (max == std2Cnt) answer.add(2);
        if (max == std3Cnt) answer.add(3);
        
        return answer;
    }
}