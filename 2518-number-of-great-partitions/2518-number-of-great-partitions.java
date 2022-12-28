class Solution {
    //https://leetcode.com/discuss/interview-question/1279773/google-interview-question-array-subset-sum-equals-k
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[k];
        int mod = (int)1e9+7, ans = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans*2)%mod;
        }
        dp[0] = 1;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            for (int j = k - 1; j >= nums[i] ; j--) {
                dp[j] = (dp[j] + dp[j - nums[i]]) % mod;
            }
        }
        if(totalSum < 2L*k){
            return 0;
        }
        int dpSum = 0;
        for (int i = 0; i < k; i++) {
            dpSum = (dpSum + dp[i]) % mod;
        }
        return (ans - 2*dpSum + mod) % mod;
    }
}