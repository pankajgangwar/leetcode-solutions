class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[]dp = new long[n+1];
        long mod =(long)1e9+7;
        long share = 0;
        long res = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = share = (share + dp[Math.max(0, i -delay)] - dp[Math.max(0, i - forget)] + mod) % mod;
        }
        for (int i = n - forget + 1; i <= n ; i++) {
            res = (res + dp[i]) % mod;
        }
        return (int)res;
    }
}