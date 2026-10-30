import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> finishList = new ArrayList<>();
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        
        for (int i=0; i<progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                finishList.add((100 - progresses[i]) / speeds[i]);   
            } else {
                finishList.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        for (int i=0; i<finishList.size() - 1; i++) {
            if (finishList.get(i) > finishList.get(i + 1)) {
                finishList.set(i + 1, finishList.get(i));
            }
        }
        
        for (int num : finishList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>(countMap.values());
        
        return result;
    }
}