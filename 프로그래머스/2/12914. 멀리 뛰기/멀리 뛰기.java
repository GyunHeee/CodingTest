import java.util.*;

class Solution {
    
    int[] dp;
    
    public long solution(int n) {
        int answer = 0;
        dp = new int[n + 2];
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        answer = dp[n];
        // answer = fibo(n);
         
        return answer;
    }
    
    int fibo(int n) {
        if (n == 1) {
            return dp[1];
        }
        
        if (n==2) {
            return dp[2];
        }
        
        if (dp[n] == 0) {
            dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        } 
        
        return dp[n];
    }
}  