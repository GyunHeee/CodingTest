import java.util.*;

class Solution {
    
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean found = false;

    public int solution(String word) {
        dfs(word, "");
        return count;
    }
    
    void dfs(String word, String current) {
        if (found) {
            return;
        }
        
        if (current.length() > 5) {
            return;
        }
        
        if (word.equals(current)) {
            found = true;
            return;
        }
        
        for (String vowel: vowels) {
            dfs(word, current + vowel);
        }
        
        count++;
    }
}