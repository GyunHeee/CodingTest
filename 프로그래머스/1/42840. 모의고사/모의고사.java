import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        List<Integer> answer = new ArrayList<>();
        int maxNum = 0;
        
        int student1Cnt = 0;
        int student2Cnt = 0;
        int student3Cnt = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                student1Cnt++;
            }
            
            if (answers[i] == student2[i % student2.length]) {
                student2Cnt++;
            }
            
            if (answers[i] == student3[i % student3.length]) {
                student3Cnt++;
            }
        }
        
        maxNum = Math.max(Math.max(student1Cnt, student2Cnt), student3Cnt);
        
        if (maxNum == student1Cnt) answer.add(1);
        if (maxNum == student2Cnt) answer.add(2);
        if (maxNum == student3Cnt) answer.add(3);
        
        return answer;
    }
}