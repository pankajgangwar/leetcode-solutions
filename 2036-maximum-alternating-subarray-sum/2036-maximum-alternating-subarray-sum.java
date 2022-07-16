class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
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