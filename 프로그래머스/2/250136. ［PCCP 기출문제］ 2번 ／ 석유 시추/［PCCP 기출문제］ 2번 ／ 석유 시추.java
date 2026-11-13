import java.util.*;

class Solution {
    Map<Integer, Integer> chunkSizes = new HashMap<>();
    int chunkId = 2;
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (land[i][j] == 1 && !visited[i][j])
                    bfs(visited, i, j, land);
            }
        }
        
        int maxOil = 0;
        
        for (int x = 0; x < m; x++) {
            Set<Integer> hitChunks = new HashSet<>();
            int currentOil = 0;
            
            for (int y=0; y<n; y++) {
                if (land[y][x] > 1) {
                    hitChunks.add(land[y][x]);
                }
            }
            
            for (int id : hitChunks) {
                currentOil += chunkSizes.get(id);
            }
            
            maxOil = Math.max(maxOil, currentOil);
        }
        
        return maxOil;
    }
    
    void bfs(boolean[][] visited, int startY, int startX, int[][] land) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = land.length;
        int m = land[0].length;
        
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        land[startY][startX] = chunkId;
        
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0,0,-1,1};
        
        int size = 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            
            for (int i=0; i<4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                
                if (nx < 0 || ny < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (land[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                land[ny][nx] = chunkId;
                size++;
                queue.offer(new int[]{ny, nx});
            }
        }
        chunkSizes.put(chunkId, size);
        chunkId++;
    }   
}