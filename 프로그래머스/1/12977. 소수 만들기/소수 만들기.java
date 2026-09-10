class Solution {
    
    int answer = 0;
    
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(0, nums, visited, 0);

        return answer / 6;
    }
    
    boolean isPrime(int num) {
        boolean prime = true;
        
        if (num == 1 || num == 0) {
            prime = false;
        }
        
        for (int i=2; i<num; i++) {
            if (num % i == 0) prime = false;
        }
        
        return prime;
    }
    
    void dfs(int sum, int[] nums, boolean[] visited, int count) {
        
        if (count == 3) {
            if (isPrime(sum)) {
                answer++;
            }
            
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(sum + nums[i], nums, visited, count + 1);
            visited[i] = false;
        }
    }
}