class Solution {
    
    int max = 100;
    int inf = (int)1e9+7;
    Integer[][] memo = new Integer[max][max];
    int[][] cost = new int[max][max];
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int median = houses[(i + j) / 2];
                for (int m = i; m <= j ; m++) {
                    cost[i][j] += Math.abs(houses[m] - median);
                }
            }
        }
        return dp(houses, k, 0);
    }

    private int dp(int[] houses, int k, int i) {
        int n = houses.length;
        if(n == i && k == 0) return 0;
        if(n == i || k == 0) return inf;
        if(memo[k][i] != null) return memo[k][i];
        int ans = inf;
        for (int j = i; j < n ; j++) {
            ans = Math.min(ans, cost[i][j] + dp(houses, k - 1, j + 1));
        }
        return memo[k][i] = ans;
    }
    
    public int minDistance1(int[] houses, int k) {
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