class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] memo = new int[n][d+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(jobDifficulty, memo, d, 0);
    }

    private int dfs(int[] jobDifficulty, int[][] memo, int d, int currJob) {
        int n = jobDifficulty.length;
        if(d == 0 && currJob == n) return 0;
        if(d == 0 || currJob == n ) return Integer.MAX_VALUE;
        if(memo[currJob][d] != -1) return memo[currJob][d];

        int currMax = jobDifficulty[currJob];
        int min = Integer.MAX_VALUE;
        for (int nextJob = currJob; nextJob < n ; nextJob++) {
            currMax = Math.max(currMax, jobDifficulty[nextJob]);
            int temp = dfs(jobDifficulty, memo, d - 1, nextJob + 1);
            if(temp != Integer.MAX_VALUE){
                min = Math.min(min, temp + currMax);
            }
        }
        return memo[currJob][d] = min;
    }
}