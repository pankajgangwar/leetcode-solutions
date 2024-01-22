class Solution {
    public int numTilings(int n) {
        int[] dp = new int[n + 1];
        if(n == 1) return 1;
        if(n == 2) return 2;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        int mod = (int)1e9 + 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i-1]) % mod) + dp[i - 3];
            dp[i] = dp[i] % mod;
        }
        return dp[n];
    }
}