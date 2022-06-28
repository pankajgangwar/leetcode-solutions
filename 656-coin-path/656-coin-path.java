class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] next = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(next, -1);
        helper(coins, maxJump, 0, next, dp);
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 0; i < n && next[i] >= 0 ; i = next[i]) {
            ans.add(next[i] + 1);
        }
        if(!ans.contains(n)) return new ArrayList<>();
        return ans;
    }


    public int helper(int[] coins, int maxJump, int start, int[] next, int[] dp){
        int n = coins.length;
        if(dp[start] != -1) return dp[start];
        if(start == n - 1) {
            return coins[start];
        }
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = start + 1; i <= Math.min(start + maxJump, n - 1) ; i++) {
            if(coins[i] != -1){
                int curr = helper(coins, maxJump, i, next, dp);
                if(curr < minCost){
                    minCost = curr;
                    minIdx = i;
                }
            }
        }
        if(minCost == Integer.MAX_VALUE){
            dp[start] = minCost;
        }else{
            dp[start] = coins[start] + minCost;
        }
        next[start] = minIdx;
        return dp[start];
    }
}