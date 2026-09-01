import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char current = number.charAt(i);
            
            while (
                !stack.isEmpty() &&
                k > 0 &&
                current > stack.peek()
            ) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }

        for (char digit : stack) {
            answer.append(digit);
        }
        
        return answer.toString();
    }
}