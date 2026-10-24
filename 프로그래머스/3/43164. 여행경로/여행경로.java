import java.util.*;

class Solution {
    
    boolean isFinish = false;
    List<String> answer = new ArrayList<>();
    
    public List<String> solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[0].compareTo(b[0]);
        });
        
        boolean[] visited = new boolean[tickets.length + 1];
        answer.add("ICN");
        dfs(tickets, visited, "ICN");
        return answer;
    }
    
    void dfs(String[][] tickets, boolean[] visited, String cur) {
        if (answer.size() == tickets.length + 1) {
            isFinish = true;
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            for (int j=0; j<visited.length; j++) {
                System.out.print(visited[j] + " ");
            }
            if (visited[i]) continue;
            if (tickets[i][0].equals(cur)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                dfs(tickets, visited, tickets[i][1]);
                
                if (isFinish) return;
                visited[i] = false;    
                answer.remove(answer.size() - 1);
            }
        }
    }
}