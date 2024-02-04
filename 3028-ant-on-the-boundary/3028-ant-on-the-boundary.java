class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            sum += a;
            if(sum == 0){
                count++;
            }
        }
        return count;
    }
}