class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        for (int i = 0; i < m; i++ ) {
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = dfs(houses, cost, m, n, target, 0, 0, -1, dp);
        return res == max ? -1 : res;
    }

    int max = (int)1e9;
    public int dfs(int[] h, int[][] c, int m, int n, int target, int housePainted, int currTarget, int neighColor, int[][][] dp) {
        if(housePainted == m) {
            if(target == currTarget) return 0;
            return max;
        }
        if(currTarget == target + 1) return max;
        if(neighColor != -1){
            if(dp[housePainted][neighColor][currTarget] != -1) return dp[housePainted][neighColor][currTarget];
        }
        int res = max;
        for (int currColor = 0; currColor < n; currColor++) {
            boolean needPaint = true;
            if (h[housePainted] != 0) { // If house is already painted
                if(h[housePainted] != currColor + 1){ // If color is not same as neighbor, skip it
                  continue;
                }else{
                   needPaint = false;
                }
            }
            if (currColor != neighColor) {
                res = Math.min(res, dfs(h, c, m, n, target, housePainted + 1, currTarget + 1, currColor, dp) + ((!needPaint) ? 0 : c[housePainted][currColor]));
            }else {
                res = Math.min(res, dfs(h, c, m, n, target, housePainted + 1, currTarget, currColor, dp) + ((!needPaint) ? 0 : c[housePainted][currColor]));
            }
        }
        if(neighColor != -1) {
            dp[housePainted][neighColor][currTarget] = res;
        }
        return res;
    }
}