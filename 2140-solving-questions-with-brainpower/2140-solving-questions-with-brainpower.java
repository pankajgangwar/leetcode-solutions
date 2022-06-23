class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        dp = new Long[n+1];
        return dfs(0, q);
    }

    Long[] dp;
    public long dfs(int start, int[][] q){
        if(start >= q.length) return 0L;
        if(dp[start] != null) return dp[start];
        long max = Math.max(q[start][0] + dfs(q[start][1] + start + 1, q), dfs(start + 1, q));
        return dp[start] = max;
    }
}