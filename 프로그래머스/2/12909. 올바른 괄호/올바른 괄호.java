import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == '(') {
                stack.push(cur);
            } else if (cur == ')') {
                if (stack.isEmpty()) {
                    stack.push(cur);
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) answer = true;
        
        return answer;
    }
}