import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited, new int[]{0,0,1});
    }
    
    int bfs(int[][] maps, boolean[][] visited, int[] cur) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        visited[cur[0]][cur[1]] = true;
        queue.offer(cur);
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];
            int dist = current[2];
            
            if (curY == maps.length - 1 && curX == maps[0].length - 1) {
                return dist;
            }
            
            for (int i=0; i<4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                
                if (ny >= maps.length || ny <0 || nx >= maps[0].length || nx <0)
                    continue;
                if (maps[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
            
                queue.offer(new int[]{ny, nx, dist + 1});
            }
        }
        
        return -1;
    }
}