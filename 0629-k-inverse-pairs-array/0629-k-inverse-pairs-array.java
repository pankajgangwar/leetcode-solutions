class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        int mod = (int)1e9 + 7;
        //dp[n][k] = dp[n-1][k - i - 1];
        for (int N = 1; N <= n; N++) {
            for (int K = 0; K <= k; K++) {
                for(int i = 0; i <= Math.min(K, N-1) ; i++) {
                    dp[N][K] = (dp[N][K] + dp[N-1][K - i]) % mod;
                }
            }
        }
        
        return dp[n][k];
    }
}