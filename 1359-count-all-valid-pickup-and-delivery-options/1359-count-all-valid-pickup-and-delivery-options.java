class Solution {
    public int countOrders(int n) {
        int mod = (int)1e9+7;
        long[] dp = new long[n + 1];
        dp[1] = 1l;
        if(n == 1) return (int)dp[1];
        dp[2] = 6l;
        
        for (int i = 3; i <= n; i++) {
            long space = (i-1)*2 + 1;
            long sum = space * (space + 1) / 2;
            dp[i] = dp[i-1]*sum % mod;
        }
        return (int)dp[n];
    }
}