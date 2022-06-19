class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] memo = new int[amount + 1];
       Arrays.fill(memo, -1);
        
        coins = Arrays.stream(coins).
                boxed().
                sorted((a, b) -> b.compareTo(a)). // sort descending
                mapToInt(i -> i).
                toArray();
        
       //int res = coinChangeMemo(coins, amount, coins.length, memo);
       //int res = coinChangeRec(coins, amount, coins.length);
        int res = coinChangeDP(coins, amount, coins.length);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    
    
    public int coinChangeDP(int[] coins, int amount, int n) {
        int table[] = new int[ amount + 1];

        table[0] = 0;

        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i){
                    int sub_res = table[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]){
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[amount];
    }
    
    public int coinChangeMemo(int[] coins, int amount, int n, int[]memo) {
       if(amount == 0){
            return 0;
        }
        
        if(memo[amount] != -1){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(coins[i] <= amount) {
                int res_sub = coinChangeMemo(coins, amount - coins[i], n, memo);
                
                if(res_sub != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + res_sub);
                }
            }
        }
        
        memo[amount] = res;

        return memo[amount];
    }

   public int coinChangeRec(int[] coins, int amount, int n) {
       if(amount == 0){
            return 0;
        }
       
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(coins[i] <= amount) {
                int res_sub = coinChangeRec(coins, amount - coins[i], n);
                
                if(res_sub != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + res_sub);
                }
            }
        }

        return res;
    }
}