class Solution {
    
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int)1e9 + 7;
        
        int[][] dp = new int[n+1][6];
        
        for(int a = 0; a < 6; ++a){
            for(int len = 1; len <= Math.min(n, rollMax[a]); ++len){
                dp[len][a]++;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < 6; ++prev){
                for(int next = 0; next < 6; ++next){
                    if(prev == next) continue;
                    
                    for(int len = 1; len <= rollMax[next] && i + len <= n; ++len){
                        dp[i+len][next] = (dp[i+len][next] + dp[i][prev])  % mod ;
                    }
                }
            }
        }
        
        int ways = 0;
        for(int a = 0; a < 6; ++a){
             ways = ( ways + dp[n][a] ) % mod;
        }
        return ways;
    }
}