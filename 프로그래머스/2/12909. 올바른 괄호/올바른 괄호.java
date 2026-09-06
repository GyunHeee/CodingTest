import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == '(') stack.push(s.charAt(i));
                else answer = false;
            }
            
            else {
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            
            if (i == s.length() - 1 && !stack.isEmpty()) {
                answer = false;
            }
        }
        
        return answer;
    }
}