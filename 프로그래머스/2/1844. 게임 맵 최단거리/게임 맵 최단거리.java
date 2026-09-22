import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(visited, maps, new int[]{0,0});
    }
    
    int bfs(boolean[][] visited, int[][] maps, int[] cur) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        int targetY = maps.length - 1;
        int targetX = maps[0].length - 1;
        
        queue.offer(cur);
        visited[cur[0]][cur[1]] = true;
        
        int[] dx = {-1, 1, 0 , 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            
            int[] curItem = queue.poll();
            if (curItem[0] == targetY && curItem[1] == targetX) {
                return maps[targetY][targetX];
            }
            
            for (int i=0; i<4; i++) {
                int y = curItem[0] + dy[i];
                int x = curItem[1] + dx[i];
                
                if (y > targetY) continue;
                if (y < 0) continue;
                if (x > targetX) continue;
                if (x < 0) continue;
                
                if (maps[y][x] == 0) continue;
                if (visited[y][x]) continue;

                int[] next = {y, x};

                visited[y][x] = true;
                maps[y][x] = maps[curItem[0]][curItem[1]] + 1;
                queue.offer(next);
            }
        }
        
        return -1;
    }
}