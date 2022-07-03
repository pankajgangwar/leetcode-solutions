class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int res = 0;
        int mod = (int)1e9+7;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + helper(i, j, grid, dp, 0)) % mod;
            }
        }
        return res;
    }

    public int helper(int i, int j, int[][] grid, int[][]dp, int prev){
        int m = grid.length;
        int n = grid[0].length;
        int mod = (int)1e9+7;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] <= prev) return 0;
        if(dp[i][j] == 0){
            int a = helper(i-1, j, grid, dp, grid[i][j]);
            int b = helper(i+1, j, grid, dp, grid[i][j]);
            int c = helper(i, j-1, grid, dp, grid[i][j]);
            int d = helper(i, j+1, grid, dp, grid[i][j]);
            dp[i][j] = 1 + a + b + c + d;
        }
        return dp[i][j] % mod;
    }
}