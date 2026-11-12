import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        List<List<int[]>> robotTimelines = new ArrayList<>();
        
        for (int[] route : routes) {
            List<int[]> timeline = new ArrayList<>();
            
            int startPointIdx = route[0] - 1; 
            int r = points[startPointIdx][0];
            int c = points[startPointIdx][1];
            timeline.add(new int[]{r, c});
            
            for (int i = 1; i < route.length; i++) {
                int targetPointIdx = route[i] - 1;
                int tr = points[targetPointIdx][0];
                int tc = points[targetPointIdx][1];
                
                while (r != tr) {
                    if (r < tr) r++;
                    else r--;
                    timeline.add(new int[]{r, c});
                }
                
                while (c != tc) {
                    if (c < tc) c++;
                    else c--;
                    timeline.add(new int[]{r, c});
                }
            }
            robotTimelines.add(timeline);
        }
        
        int time = 0;
        
        while (true) {
            // 이번 시간에 살아있는(아직 도착 안 한) 로봇들의 좌표를 모을 맵 또는 카운터
            Map<String, Integer> positionCount = new HashMap<>();
            int activeRobots = 0;
            
            for (List<int[]> timeline : robotTimelines) {
                if (time < timeline.size()) {
                    int[] pos = timeline.get(time);
                    String key = pos[0] + "," + pos[1]; // "r,c" 형태의 문자열 키
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                    activeRobots++;
                }
            }
            
            // 모든 로봇이 목적지에 도달했으면 시뮬레이션 종료
            if (activeRobots == 0) break;
            
            // 해당 시간에 2대 이상 모인 좌표가 있는지 확인
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
            
            time++;
        }
        
        return answer;
    }
}