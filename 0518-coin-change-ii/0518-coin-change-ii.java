class Solution {
    public int change(int amount, int[] coins) {
        //return coinChangeIIRec(amount, coins, coins.length);
        
        /*int[][] memo = new int[coins.length+1][amount+1];
        int res = coinChangeIIMemo(amount, coins, coins.length, memo);
        return res;*/
        return coinChangeDP2(amount, coins);
    }

    public int coinChangeDP2(int amount, int[] coins){
        int n = coins.length;
        if(amount == 0) return 1;
        if(n == 0) return 0;
        int[][] dp = new int[coins.length +1][amount +1];
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j <= amount; j++){
            dp[0][j] = 0;
        }
        
        // dp[i-1][j] : If I don't use this coin
        // dp[i][j - coins[i - 1]] : If ith coin is used, ways for amount j - coins[i - 1] 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
    
     public int coinChangeIIDP(int amount, int[] coins, int n) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //if(coins[i] <= j) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                //}
            }
        }
        return dp[amount];
    }
    
    public int coinChangeIIMemo(int amount, int[] coins, int n, int[][] memo) {
        if(amount == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(memo[n][amount] != 0){
            return memo[n][amount];
        }
        if(coins[n-1] > amount) {
            memo[n][amount] = coinChangeIIMemo(amount, coins, n - 1, memo);
            return memo[n][amount];
        }
        
        memo[n][amount] = coinChangeIIMemo(amount - coins[n - 1], coins, n, memo ) +
                coinChangeIIMemo(amount , coins , n - 1, memo);
        return memo[n][amount];
    }

    public int coinChangeIIRec(int amount, int[] coins, int n) {
        if(amount == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(coins[n-1] > amount) {
            return coinChangeIIRec(amount, coins, n - 1);
        }
        
        return coinChangeIIRec(amount - coins[n - 1], coins, n ) +
                coinChangeIIRec(amount , coins ,n -1);
    }
}