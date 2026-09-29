import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        Set<String> visitedEdges = new HashSet<>();
        
        for (int i=0; i<dirs.length(); i++) {
            char direction = dirs.charAt(i); 
            int nx = x;
            int ny = y;
            
            if (direction == 'U') ny++;
            else if (direction == 'D') ny--;
            else if (direction == 'L') nx--;
            else if (direction == 'R') nx++;
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String path1 = x + " " + y + "->" + nx + " " + ny;
            String path2 = nx + " " + ny + "->" + x + " " + y;
            
            visitedEdges.add(path1);
            visitedEdges.add(path2);
            
            x = nx;
            y = ny;
        }
        
        return visitedEdges.size() / 2;
    }
}