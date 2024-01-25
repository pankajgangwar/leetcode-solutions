class Solution {
    public int minSubArrayLen(int targetSum, int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int currSum = nums[j++];
        int n = nums.length;
        while(i < n){
            while(currSum < targetSum && j < n){
                currSum += nums[j++];
            }
            if(currSum >= targetSum){
                min = Math.min(min, j - i);
            }
            currSum -= nums[i++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}