class Solution {
    public int tallestBillboard(int[] rods) {
        int remaining = Arrays.stream(rods).sum();
        int n = rods.length;
       // helper(rods, n - 1, 0, 0, remaining);
       // return globalMax;
        return dpSol(rods);
    }
    
    public int dpSol(int[] rods){
        int n = rods.length;
        int maxSum = 10000;
        boolean[][] dp = new boolean[n+1][maxSum+1];
        int[][]max = new int[n+1][maxSum+1];
        dp[0][maxSum / 2] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                if(j - rods[i] >= 0 && dp[i][j-rods[i]]){
                    dp[i+1][j] = true;
                    max[i+1][j] = Math.max(max[i+1][j], max[i][j-rods[i]] + rods[i]);
                }
                if(j + rods[i] <= maxSum && dp[i][j + rods[i]]){
                    dp[i+1][j] = true;
                    max[i+1][j] = Math.max(max[i+1][j], max[i][j+rods[i]]);
                }
                if(dp[i][j]){
                    dp[i+1][j] = true;
                    max[i+1][j] = Math.max(max[i+1][j], max[i][j]);
                }
            }
        }
        return max[n][maxSum / 2];
    }

    int globalMax = 0;
    public void helper(int[] rods, int i, int first, int second, int remaining){
        if(i < 0){
            if(first == second){
                globalMax = Math.max(globalMax, first);
            }
            return;
        }
        if(first + second + remaining <= 2 * globalMax ||
                Math.abs(first - second) > remaining) return;

        helper(rods, i-1, first + rods[i], second, remaining - rods[i]);

        helper(rods, i-1, first, second + rods[i], remaining - rods[i]);
        helper(rods, i-1, first, second, remaining - rods[i]);
    }
}