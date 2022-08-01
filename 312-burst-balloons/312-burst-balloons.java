class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        Arrays.fill(balloons, 1);
        for(int i = 0; i < n; i++){
            balloons[i + 1] = nums[i];
        }
        n = balloons.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Arrays.toString(balloons));
        return dfs(balloons, 0, n - 1, dp);
    }
    
    public int dfs(int[] nums, int left, int right, int[][] dp){
        if(left + 1 == right){
            return 0;
        }
        if(dp[left][right] > 0){
            return dp[left][right];
        }
        int max = -1;
        for(int i = left + 1; i < right; i++){
            max = Math.max(max, (nums[left] * nums[i] * nums[right]) +
                dfs(nums, left, i, dp) + dfs(nums, i, right, dp));
        }
        dp[left][right] = max;
        return max;
    }
    
}