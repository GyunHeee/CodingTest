import java.util.*;

class Solution {
    public List<Integer> solution(int[] prices) {
        List<Integer> arr = new ArrayList<>();
        
        for (int i=0; i<prices.length; i++) {
            boolean isMin = false;
            for (int j=i + 1; j<prices.length; j++) {
                if (prices[i] > prices[j]) {
                    isMin = true;
                    arr.add(j - i);
                    break;
                }
                
                if (j == prices.length - 1 && isMin == false) {
                    arr.add(prices.length - 1 - i);
                    break;
                }
            }
        }
        
        arr.add(0);
        
        return arr;
    }
}