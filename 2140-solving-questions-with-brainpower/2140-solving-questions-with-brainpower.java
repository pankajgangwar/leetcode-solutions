class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        dp = new long[n+1];
        //return dfs(0, q);
        return dpSol(q);
    }
    
    public long dpSol(int[][] q){
        int n = q.length;
        //dp[1] = (long)q[0][0];
        for (int i = n - 1; i >= 0; i--) {
            int skip = q[i][1];
            int points = q[i][0];
            dp[i] = Math.max(points + dp[Math.min(i + skip + 1, n)], dp[i+1]);
        }
        return dp[0];
    }

    long[] dp;
    public long dfs(int start, int[][] q){
        if(start >= q.length) return 0L;
        if(dp[start] != 0L) return dp[start];
        long max = Math.max(q[start][0] + dfs(q[start][1] + start + 1, q), dfs(start + 1, q));
        return dp[start] = max;
    }
}