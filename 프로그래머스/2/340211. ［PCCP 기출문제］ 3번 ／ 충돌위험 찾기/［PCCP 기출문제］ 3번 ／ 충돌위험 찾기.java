import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        List<List<int[]>> robotTimelines = new ArrayList<>();
        
        for (int[] route : routes) {
            List<int[]> timelines = new ArrayList<>();
            
            int startPointIdx = route[0] - 1;
            int r = points[startPointIdx][0];
            int c = points[startPointIdx][1];
            timelines.add(new int[]{r, c});
            
            for (int i = 1; i < route.length; i++) {
                int targetPointIdx = route[i] - 1;
                int tr = points[targetPointIdx][0];
                int tc = points[targetPointIdx][1];
                
                while (r != tr) {
                    if (r < tr) r++;
                    else r--;
                    timelines.add(new int[]{r, c});
                }
                
                while (c != tc) {
                    if (c < tc) c++;
                    else c--;
                    timelines.add(new int[]{r, c});
                }
            }
            
            robotTimelines.add(timelines);
        }
        
        int time = 0;
        
        while (true) {
            Map<String, Integer> positionCount = new HashMap<>();
            int activeRobots = 0;
            
            for (List<int[]> timeline : robotTimelines) {
                if (time < timeline.size()) {
                    int[] pos = timeline.get(time);
                    String key = pos[0] + "," + pos[1];
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                    activeRobots++;
                }
            }
            
            if (activeRobots == 0) break;
            
            for (int count : positionCount.values()) {
                if (count >= 2) answer++;
            }
            
            time++;
        }
        
        return answer;
    }
}