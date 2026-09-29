import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String dup = "";
        
        for (int j=0; j<s.length(); j++) {
            for (int i=1; i<s.length(); i++) {
                dup += s.charAt(i);
            }
            dup += s.charAt(0);

            if (isOkay(dup)) answer++;   
            s = dup;
            dup = "";
        }
        
        return answer;
    }
    
    private boolean isOkay(String s) {
        boolean okay = false;
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    stack.push(cur);
                    continue;
                }
                
                if (cur == ')') {
                    if (stack.peek() == '(') stack.pop();
                }
                
                if (cur == '}') {
                    if (stack.peek() == '{') stack.pop();
                }
                
                if (cur == ']') {
                    if (stack.peek() == '[') stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) okay = true;
        
        return okay;
    }
}