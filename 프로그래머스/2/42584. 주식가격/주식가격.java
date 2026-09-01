import java.util.*;

class Solution {
    public List<Integer> solution(int[] prices) {
        List<Integer> arr = new ArrayList<>();
        
        for (int i=0; i<prices.length; i++) {
            boolean isAdd = false;
            for (int j=i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    arr.add(j - i);
                    isAdd = true;
                    break;
                }                
            }
            if (!isAdd) {
                arr.add(prices.length - 1 - i);    
            }
        }
        
        return arr;
    }
}