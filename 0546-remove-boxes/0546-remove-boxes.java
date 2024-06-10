class Solution {
    
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(0, n - 1, 0, boxes, dp);
    }

    public int helper(int i, int j, int k, int[] boxes, int[][][] dp){
        if(i > j) return 0;
        if(dp[i][j][k] != 0) return dp[i][j][k];
        int i0 = i, k0 = k;
        for(; i+1 <= j && boxes[i+1] == boxes[i]; i++,k++);
        int res = (k + 1) * (k + 1) + helper(i + 1, j, 0, boxes, dp);
        for(int m = i + 1; m <= j; m++){
            if(boxes[i] == boxes[m]){
                res = Math.max(res, helper(i + 1, m - 1, 0, boxes, dp)
                        + helper(m, j, k+1, boxes, dp));
            }
        }
       return dp[i0][j][k0] = res;
    }
}