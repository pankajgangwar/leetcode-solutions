class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long lastMinus = Integer.MIN_VALUE;
        long lastPlus = Integer.MIN_VALUE;
        long res = Integer.MIN_VALUE;
        for(int n : nums){
            long currPlus = Math.max(lastMinus + n , n);
            long currMinus = lastPlus - n;
            res = Math.max(res, Math.max(currPlus, currMinus));
            lastPlus = currPlus;
            lastMinus = currMinus;
        }
        return res;
    }
    
    public long maximumAlternatingSubarraySum1(int[] nums) {
        return Math.max(kadane(nums, 0), kadane(nums, 1));
    }

    public long kadane(int[] nums, int p){
        long globalMax = Long.MIN_VALUE, currMax = 0;
        for (int i = p; i < nums.length ; i++) {
            if((i+p)%2 == 1){
                currMax -= nums[i];
            }else{
                currMax = Math.max(currMax + nums[i], nums[i]);
            }
            globalMax = Math.max(globalMax, currMax);
        }
        return globalMax;
    }
}