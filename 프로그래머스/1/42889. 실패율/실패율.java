import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        int[] answer = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Double> resultMap = new HashMap<>();
        
        int peopleCnt = stages.length;
        Arrays.sort(stages);
        
        for (int i=0; i<stages.length; i++) {
            if (map.get(stages[i]) != null) {
                map.put(stages[i], map.get(stages[i]) + 1);    
            } else {
                if (stages[i] <= N) {
                    map.put(stages[i], 1);    
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            int count = map.getOrDefault(i, 0);

            double rate = peopleCnt == 0
                    ? 0.0
                    : (double) count / peopleCnt;

            resultMap.put(i, rate);
            peopleCnt -= count;
        }
        
        List<Integer> stageList = new ArrayList<>(resultMap.keySet());

        stageList.sort((a, b) -> {
            double rateA = resultMap.getOrDefault(a, 0.0);
            double rateB = resultMap.getOrDefault(b, 0.0);

            if (rateA == rateB) {
                return Integer.compare(a, b);
            }
            
            return Double.compare(rateB, rateA);
        });
                
        return stageList;
    }
}