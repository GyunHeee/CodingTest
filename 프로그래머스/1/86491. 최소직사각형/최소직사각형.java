class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        
        for (int[] size: sizes) {
            int a = size[0];
            int b = size[1];
            
            if (a < b) {
                size[1] = a;
                size[0] = b; 
            }
        }
        
        for (int[] size: sizes) {
            if (size[0] > maxW) {
                maxW = size[0];
            }
            
            if (size[1] > maxH) {
                maxH = size[1];
            }
        }
        
        return maxW * maxH;
    }
}