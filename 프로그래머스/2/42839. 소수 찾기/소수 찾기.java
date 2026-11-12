import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);
        
        return set.size();
    }
    
    void dfs(String numbers, String cur, boolean[] visited) {
        
        if (!cur.equals("") && isPrime(cur)) {
            set.add(Integer.valueOf(cur));
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, cur + numbers.charAt(i), visited);
            visited[i] = false;
        }
    }
    
    boolean isPrime(String numStr) {
        Integer num = Integer.valueOf(numStr);
        
        if (num == 1 || num == 0) return false;
        
        for (int i=2; i<num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
    
}