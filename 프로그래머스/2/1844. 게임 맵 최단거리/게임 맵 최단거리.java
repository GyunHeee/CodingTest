import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited);
    }
    
    int bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        
        visited[0][0] = true;
        queue.offer(new int[]{0,0,1});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int dist = cur[2];
            
            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, -1, 1};
            
            if (curY == n-1 && curX == m -1) {
                return dist;
            }
            
            for (int i=0; i<4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                
                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (maps[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx, dist + 1});
            }
        }
        
        return -1;
    }
}