class Solution {    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(visited, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] computers, int cur) {
        visited[cur] = true;
        
        for (int i=0; i<computers[cur].length; i++) {
            if (!visited[i] && computers[cur][i] == 1) {
                dfs(visited, computers, i);
            }
        }
    }
}