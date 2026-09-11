import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k = k - 1;
            }

            stack.push(num);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int s : stack) {
            sb.append(s);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}