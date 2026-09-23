import java.util.*;

class Solution {
    
    List<String> answer = new ArrayList<>();
    boolean isFinished = false;
    
    public List<String> solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        answer.add("ICN");
        dfs(visited, tickets, "ICN", 0);
        return answer;
    }
    
    void dfs(boolean[] visited, String[][] tickets, String cur, int depth) {
        
        if (depth == tickets.length) {
            isFinished = true;
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                
                visited[i] = true;
                answer.add(tickets[i][1]);
                dfs(visited, tickets, tickets[i][1], depth + 1);
                
                if (isFinished) return;
                visited[i] = false;
                answer.remove(answer.size() - 1);  
            } 
        }
    }
}