class Solution {
    public int solution(int[] diffs, int[] times, long limit) {    
        int left = 1;
        int right = 1;
        
        for (int d : diffs) {
            right = Math.max(right, d);
        }
        
        int answer = right;
        
        while (left <= right) {
            int answer_mid = (left + right) / 2;
            long time = 0;
            
            for (int i=0; i<diffs.length; i++) {
                if (i == 0) {
                    if (diffs[i] <= answer) {
                        time += times[i];
                    } else {
                        int diff = diffs[i] - answer_mid;
                        time += (long)diff * times[i] + times[i];
                    }
                } else {
                    if (diffs[i] <= answer_mid) {
                        time += times[i];
                    } else {
                        int diff = diffs[i] - answer_mid;
                        time += (long)diff * (times[i] + times[i - 1]) + times[i];
                    }
                } 
            }
            
            if (limit >= time) {
                answer = answer_mid; // 일단 가능한 답으로 저장해두고
                right = answer_mid - 1; // 더 작은 숙련도(좌측)도 가능한지 탐색
            } else {
                left = answer_mid + 1; // 시간이 초과되면 숙련도를 높여야 하므로 우측 탐색
            }
        }
        
        return answer;
    }
}