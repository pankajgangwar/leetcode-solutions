class Solution {
    public int waysToReachTarget(int amount, int[][] types) {
        int dp[] = new int[amount + 1];
        int mod = (int) 1e9 + 7;
        dp[0] = 1;
        for(int[] type : types){
            for(int i = amount; i > 0; i--){
                for(int j = 1; j <= type[0] && i - j * type[1] >= 0; j++){
                    dp[i] = (dp[i] + dp[i - j * type[1]]) % mod;
                }
            }
        }
        return dp[amount];
    }
}