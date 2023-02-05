class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robDP0(nums), robDP1(nums));
    }

    public int robDP0(int[] nums){
        if(nums.length == 0) return 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length -1; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public int robDP1(int[] nums){
        if(nums.length == 0) return 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public int robRec(int[] nums, int n){
        if(n < 0){
            return 0;
        }
        return Math.max(robRec(nums, n-2) + nums[n], robRec(nums, n-1));
    }
}