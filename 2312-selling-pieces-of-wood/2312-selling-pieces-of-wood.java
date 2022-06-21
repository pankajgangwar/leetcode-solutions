class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }
        for (int w = 1; w <= m ; w++) {
            for (int h = 1; h <= n; h++) {
                for (int a = 1; a < w; a++) {
                    dp[w][h] = Math.max(dp[w][h], dp[a][h] + dp[w - a][h]);
                }
                for (int a = 1; a < h; a++) {
                    dp[w][h] = Math.max(dp[w][h], dp[w][a] + dp[w][h - a]);
                }
            }
        }
        return dp[m][n];
    }
}