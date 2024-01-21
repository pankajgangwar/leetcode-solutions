class Solution {
    public int lengthOfLongestSubsequence(List<Integer> list, int sum) {
        int[] nums = list.stream().mapToInt(i-> i).toArray();
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]] != -1)
                    dp[i][j] = Math.max(1 + dp[i - 1][j - nums[i - 1]], dp[i][j]);
            }
        }

        return dp[n][sum];
    }
    
    public int lengthOfLongestSubsequence11(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]] != -1)
                    dp[i][j] = Math.max(1 + dp[i - 1][j - nums[i - 1]], dp[i][j]);
            }
        }

        return dp[n][sum];
    }
}