import java.util.*;

class Solution {
    
    List<String> route = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    boolean found = false;
    
    public List<String> solution(String[][] tickets) {        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[0].compareTo(b[0]);
        });
        
        boolean[] visited = new boolean[tickets.length + 1];
        dfs("ICN", 0, tickets, visited);
        
        return answer;
    }
    
    void dfs(String cur, int cnt, String[][] tickets, boolean[] visited) {
        route.add(cur);
        
        if (cnt == tickets.length) {
            answer = route;
            found = true;
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (visited[i]) continue;
            
            if (tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(tickets[i][1], cnt + 1, tickets, visited);
                if (found) return;
                visited[i] = false;
            }
        }
        
        route.remove(route.size() - 1);
    }
}