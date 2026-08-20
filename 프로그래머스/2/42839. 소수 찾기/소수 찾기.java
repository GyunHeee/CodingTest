import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs("", numbers, visited);
        
        return set.size();
    }
    
    void dfs(String current, String numbers, boolean[] visited) {
        System.out.println(current);
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(current + numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }
        
    }
    
    
    
    boolean isPrime(int number) {
        if (number == 1 || number == 0) {
            return false;
        }
        
        for (int i=2; i<number; i++) {
            if (number % i == 0) return false;
        }
    
        return true;
    }
}