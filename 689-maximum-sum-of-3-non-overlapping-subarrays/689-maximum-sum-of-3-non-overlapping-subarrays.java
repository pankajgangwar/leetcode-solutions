class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1], leftPos = new int[n], rightPos = new int[n];
        int maxSum = 0;
        int[] res = new int[3];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i - 1];
        }
        for (int i = k, tot = prefix[k] - prefix[0]; i < n ; i++) {
            int currSum = prefix[i + 1] - prefix[i - k + 1];
            if(currSum > tot){
                leftPos[i] = i - k + 1;
                tot = currSum;
            }else{
                leftPos[i] = leftPos[i-1];
            }
        }
        rightPos[n-k] = n-k;
        for (int i = n - k - 1, tot = prefix[n] - prefix[n-k]; i >= 0 ; i--) {
            int currSum = prefix[i + k] - prefix[i];
            if(currSum >= tot){
                rightPos[i] = i;
                tot = currSum;
            }else{
                rightPos[i] = rightPos[i+1];
            }
        }
        for (int i = k; i <= n - 2 * k; i++) {
            int l = leftPos[i-1];
            int r = rightPos[i+k];
            int tot = (prefix[i+k] - prefix[i]) + (prefix[l+k] - prefix[l]) + (prefix[r+k] - prefix[r]);
            if(maxSum < tot){
                res[0] = l;
                res[1] = i;
                res[2] = r;
                maxSum = tot;
            }
        }
        return res;
    }
}