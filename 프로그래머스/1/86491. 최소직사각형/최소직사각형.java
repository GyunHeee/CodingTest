class Solution {
    public int solution(int[][] sizes) {
        
        int maxWeight = 0;
        int maxHeight = 0;
        
        for (int i=0; i<sizes.length;i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        for (int i=0; i<sizes.length;i++) {
            if (sizes[i][0] > maxWeight) {
                maxWeight= sizes[i][0];
                maxHeight = sizes[i][1];
            }
        }
        
        for (int i=0; i<sizes.length;i++) {
            if (sizes[i][1] > maxHeight) {
                maxHeight = sizes[i][1];
            }
        }
        
        return maxWeight * maxHeight;
    }
}