import java.util.*;

class Solution {
    
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean found = false;
    
    public int solution(String word) {
        dfs("", word);
        return count;
    }
    
    void dfs(String cur, String word) {
        if (found == true) return;
        if (!cur.equals("")) count++;
        
        if (word.equals(cur)) {
            found = true;
            return;
        }
        
        if (cur.length() >= 5) return;
        
        for (int i=0; i<vowels.length; i++) {
            dfs(cur + vowels[i], word);
            if (found) return;
        }
    }
}