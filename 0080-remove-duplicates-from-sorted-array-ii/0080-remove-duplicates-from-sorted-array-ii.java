class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for(int a : nums){
            if(i < 2 || nums[i-2] < a){
                nums[i++] = a;
            }
        }
        return i;
    }
}