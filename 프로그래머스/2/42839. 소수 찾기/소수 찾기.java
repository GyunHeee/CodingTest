import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);
        
        return set.size();
    }
    
    void dfs(String current, String numbers, boolean[] visited) {
        if (!current.equals("") && isPrime(current)) {
            set.add(Integer.parseInt(current));
        }
        
        
        for (int i=0; i<numbers.length(); i++) {
            
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(current + numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }
    }
    
    boolean isPrime(String numstr) {
        int num = Integer.parseInt(numstr);
        
        if (num == 1 || num == 0) {
            return false;
        }
        
        for (int i=2; i<num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}