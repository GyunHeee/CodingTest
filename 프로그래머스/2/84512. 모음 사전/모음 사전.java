import java.util.*;

class Solution {
    
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean found = false;
    
    
    public int solution(String word) {
        
        dfs("", word);
        return count;
    }
    
    void dfs(String current, String word) {
        if (found == true) return;
        if (!current.equals("")) count++;
        
        if (current.equals(word)) {
            found = true;
            return;
        }
        
        if (current.length() >= 5) return;
        
        for (int i=0; i<vowels.length; i++) {
            
            dfs(current + vowels[i], word);
            if (found) return;
        }
    }
}