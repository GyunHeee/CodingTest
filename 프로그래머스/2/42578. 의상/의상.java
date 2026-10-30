import java.util.*;
import java.util.stream.*;    

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int answer = 1;
        
        for (int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            
            if (!map.containsKey(type)) {
                map.put(type, 1);
            } else {
                int cnt = map.get(type);
                map.put(type, cnt + 1);
            }
        }
        
        for (int value : map.values()) {
            answer = answer * (value + 1);
        }
        
        return answer - 1;
    }
}