import java.util.*;

class Solution {
    Map<Integer, Integer> chunkSizes = new HashMap<>();
    int chunkId = 2;
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        // 랜드끼리 묶고
        boolean[][] visited = new boolean[n][m];
        
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, visited, land);
                }
            }
        }
        
        
        
        // 열 조회해서 최대값 구하기
        int maxOil = 0;
        for (int c = 0; c < m; c++) {
            Set<Integer> hitChunks = new HashSet<>();
            int currentOil = 0;
            
            for (int r = 0; r < n; r++) {
                if (land[r][c] > 1) { // 석유 덩어리 ID가 마킹된 칸
                    hitChunks.add(land[r][c]);
                }
            }
            
            for (int id : hitChunks) {
                currentOil += chunkSizes.get(id);
            }
            
            maxOil = Math.max(maxOil, currentOil);
        }
        
        return maxOil;
    }
    
    void bfs(int startY, int startX, boolean[][] visited, int[][] land) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = land.length;
        int m = land[0].length;
        
        visited[startY][startX] = true;
        queue.offer(new int[]{startY,startX,1});
        land[startY][startX] = chunkId;
    
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        int size = 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            
            for (int i=0; i<4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                
                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (visited[ny][nx]) continue;
                if (land[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                land[ny][nx] = chunkId;
                queue.offer(new int[]{ny, nx});   
                size++;
            }
        }
        
        chunkSizes.put(chunkId, size);
        chunkId++;
    }
}