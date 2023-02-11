class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] prefSum = new int[m + 1][n + 1];
        Integer[][][] dp = new Integer[k][m][n];
        for (int r = m - 1; r >= 0 ; --r) {
            for (int c = n - 1; c >= 0 ; --c) {
                prefSum[r][c] = prefSum[r][c+1] + prefSum[r+1][c] - prefSum[r+1][c+1]
                        + (pizza[r].charAt(c) == 'A' ? 1 : 0);
            }
        }
        return dfs(prefSum, dp, k - 1, m, n, 0,0);
    }

    public int dfs(int[][] prefixSum,Integer[][][] dp, int k,
                    int m, int n, int r, int c){
        if(prefixSum[r][c] == 0) return 0;
        int mod = (int)1e9 + 7;
        if(k == 0) return 1;
        if(dp[k][r][c] != null) return dp[k][r][c];
        int ans = 0;
        for (int nr = r + 1; nr < m ; nr++) {
            if(prefixSum[r][c] - prefixSum[nr][c] > 0){
                ans = (ans + dfs(prefixSum,dp, k - 1, m,n, nr,c )) % mod;
            }
        }
        for (int nc = c + 1; nc < n ; nc++) {
            if(prefixSum[r][c] - prefixSum[r][nc] > 0){
                ans = (ans + dfs(prefixSum,dp, k - 1, m,n, r, nc )) % mod;
            }
        }
        return dp[k][r][c] = ans;
    }
}