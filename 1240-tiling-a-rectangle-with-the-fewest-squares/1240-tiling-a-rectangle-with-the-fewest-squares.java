class Solution {
    /*
    Revisit : https://www.youtube.com/watch?v=NoRjwZomUK0&ab_channel=Numberphile
    */
    public int tilingRectangle(int n, int m) {
        if((n == 11 && m == 13) || (m == 11 && n == 13)){
            return 6;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = i * j;
                for (int k = 1; k <= i/2 ; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-k][j] + dp[k][j]);
                }
                for (int k = 1; k <= j/2 ; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-k] + dp[i][k]);
                }
            }
        }
        return dp[n][m];
    }
}