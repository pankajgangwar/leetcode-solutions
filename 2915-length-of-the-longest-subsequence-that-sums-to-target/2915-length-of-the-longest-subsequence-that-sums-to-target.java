class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] arr = nums.stream().mapToInt(i-> i).toArray();
        int[][]dp = new int[n+1][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target ; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j && dp[i-1][j - arr[i-1]] != -1){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j - arr[i-1]]);
                }
            }
        }
        return dp[n][target];
    }
    
}