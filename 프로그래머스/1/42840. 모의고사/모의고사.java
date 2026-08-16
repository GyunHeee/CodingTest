import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for (int i=0; i< answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                cnt1++;
            }
            if (answers[i] == student2[i % student2.length]) {
                cnt2++;
            }
            if (answers[i] == student3[i % student3.length]) {
                cnt3++;
            }
        }
        
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        
        if (max == cnt1) answer.add(1);
        if (max == cnt2) answer.add(2);
        if (max == cnt3) answer.add(3);
        
        return answer;
    }
}