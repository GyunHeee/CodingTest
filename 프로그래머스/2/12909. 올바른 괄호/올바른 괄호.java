import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char item = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.push(item);    
            } else {
                if (item == '(') stack.push(item);
                
                if (item == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) answer = true;
        
        return answer;
    }
}