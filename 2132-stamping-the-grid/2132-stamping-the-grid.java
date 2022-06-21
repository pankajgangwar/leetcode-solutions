class Solution {
    
    public int[][] pref2d(int[][] matrix) {
        if(matrix.length == 0){
            return matrix;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
        return dp;
    }

    public int sumRegion(int[][] dp, int r1, int c1, int r2, int c2) {
        if(dp.length == 0){
            return 0;
        }
        r1++;
        c1++;
        r2++;
        c2++;

        return dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
    }
    
    public boolean possibleToStamp(int[][] grid, int h, int w) {
        int[][] pref = pref2d(grid);
        int m = grid.length;
        int n = grid[0].length;
        int[][] stamp = new int[m][n];
        for (int i = h-1; i < m ; i++) {
            for (int j = w-1; j < n; j++) {
                if(sumRegion(pref, i - h + 1, j - w + 1, i, j) == 0){
                    stamp[i][j] = 1;
                }
            }
        }
        int[][] pref2 = pref2d(stamp);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && sumRegion(pref2, i, j,
                        Math.min(m - 1 , i + h - 1 ), Math.min(n - 1, j + w - 1)) == 0){
                    return false;
                }
            }
        }
        return true;

    }
}