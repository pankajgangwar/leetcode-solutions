class Solution {
    public int countHousePlacements(int n) {
        long dp[][] = new long[n+1][4];
        // base case
        dp[1][0] = 1; // not placed any house,
        dp[1][1] = 1; // placed on one side of the street.
        dp[1][2] = 1; // placed on the other side of the street.
        dp[1][3] = 1; // placed on each side of the street.
        long mod = (long)1e9+7;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Arrays.stream(dp[i-1]).sum() % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
            dp[i][3] = (dp[i-1][0])%mod;
        }
        return (int)((Arrays.stream(dp[n]).sum()) % mod);
    }
}