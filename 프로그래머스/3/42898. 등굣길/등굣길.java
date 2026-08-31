class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        int MOD = 1000000007;
        
        for (int[] puddle : puddles) {
            int a = puddle[1];
            int b = puddle[0];
            
            dp[a-1][b-1] = -1;
        }
        
        dp[0][0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i == 0 && j == 0) continue;
                
                if (i==0) {
                    dp[i][j] = dp[i][j-1] % MOD;
                    continue;
                }
                
                if (j==0) {
                    dp[i][j] = dp[i-1][j] % MOD;
                    continue;
                }
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j-1]) % MOD;
            }
        }

        
        return dp[n-1][m-1];
    }
}