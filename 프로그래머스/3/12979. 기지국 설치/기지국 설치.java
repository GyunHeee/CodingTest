class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = 2 * w + 1;
        
        int start = 1;
        for (int station: stations) {
            int left = station - w;
            int right = station + w;
            
            if (start < left) {
                int gap = left - start;
                if (gap % range == 0) {
                    answer += gap / range;
                } else {
                    answer += gap / range + 1;
                }
            }

            start = right + 1;
        }
        
        if (start <= n) {
            int gap = n - start + 1;
            if (gap % range == 0) {
                answer += gap / range;
            } else {
                answer += gap / range + 1;
            }
        }
        
        return answer;
    }
}