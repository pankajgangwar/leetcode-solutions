class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while (n > 1){
            int[] newNums = new int[n - 1];
            for (int i = 0; i < newNums.length; i++) {
                newNums[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums = newNums;
            n -= 1;
        }
        return nums[0];
    }
}