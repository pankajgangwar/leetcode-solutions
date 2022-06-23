class Solution {
    public int rob(int[] nums) {
        //return robDP(nums);
        return robMemoIter(nums);
        
        //int[] memo = new int[nums.length];
        //Arrays.fill(memo, -1);
        //return robMemo(nums, memo, nums.length -1);
        //return robRec(nums, nums.length - 1);
    }
    
     public int robDP(int[] nums){
        if(nums.length == 0) return 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }
    
    public int robMemoIter(int[] nums){
        if(nums.length == 0 ) return 0;

        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
        }
        return dp[nums.length];
    }
    
     public int robMemo(int[] nums, int[] memo, int n){
        if(n < 0){
            return 0;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = Math.max(robRec(nums, n - 2 ) + nums[n], robRec(nums, n - 1));
        return memo[n];
    }
    
    public int robRec(int[] nums, int n){
        if(n < 0){
            return 0;
        }
        return Math.max(robRec(nums, n - 2 ) + nums[n], robRec(nums, n - 1));
    }
}