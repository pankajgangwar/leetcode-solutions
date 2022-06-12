class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int cost = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < grid[0].length; i++) {
            int currCost = dfs(0, i, grid, dp, moveCost);
            cost = Math.min(cost, currCost);
        }
        return cost;
    }

    public int dfs(int row, int col, int[][] grid,
                   Integer[][] dp, int[][] moveCost){
        int m = grid.length;
        int n = grid[0].length;
        int cell = grid[row][col];
        if(row == m - 1){
            return cell;
        }
        if(dp[row][col] != null) return dp[row][col];
        int min = Integer.MAX_VALUE;
        int[] costArr = moveCost[cell];
        for (int i = 0; i < n; i++) {
            int curr = dfs(row + 1, i, grid, dp, moveCost) + costArr[i] + cell;
            min = Math.min(min, curr);
        }
        dp[row][col] = min;
        return min;
    }
}