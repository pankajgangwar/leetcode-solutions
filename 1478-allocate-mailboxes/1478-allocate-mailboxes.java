class Solution {
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(houses, 0, 0, k, dp);
    }

    int MAX = (int)1e9;
    public int helper(int[] h, int pos, int currK, int k, int[][] dp){
        int n = h.length;
        if(pos == n){
            if(k == currK){
                return 0;
            }
            return MAX;
        }
        if(currK == k) return MAX;
        if(dp[pos][currK] != -1) return dp[pos][currK];
        int ans = MAX;
        for (int i = pos; i < n ; i++) {
            int median = h[(i+pos) / 2];
            int cost = 0;
            for(int j = pos; j <= i; j++ ){
                cost += Math.abs(h[j] - median);
            }
            ans = Math.min(ans, helper(h, i + 1, currK + 1, k, dp) + cost);
        }
        dp[pos][currK] = ans;
        return dp[pos][currK];
    }
}