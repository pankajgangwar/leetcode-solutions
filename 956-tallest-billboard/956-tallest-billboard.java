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
        int total = Arrays.stream(rods).sum();
        int[]dp = new int[total+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int rod : rods) {
            int[] current = dp.clone();
            for (int sum = 0; sum <= total - rod; sum++) {
                if(current[sum] < 0) continue;
                dp[sum+rod] = Math.max(dp[sum+rod], current[sum]);
                int a = Math.abs(sum - rod);
                dp[a] = Math.max(dp[a], current[sum] + Math.min(sum, rod));
            }
        }
        return dp[0];
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