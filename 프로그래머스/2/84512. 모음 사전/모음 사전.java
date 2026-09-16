import java.util.*;

class Solution {
    
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean found = false;
    
    public int solution(String word) {        
        dfs("", word);
        
        return count;
    }
    
    void dfs(String current, String word) {
        
        if (found) return;
        if (current.length() > 5) return;
        
        if (current.equals(word)) {
            found = true;
            return;
        }
    
        for (String vowel : vowels) {
            dfs(current + vowel, word);
        }
        
        count++;
    }
}