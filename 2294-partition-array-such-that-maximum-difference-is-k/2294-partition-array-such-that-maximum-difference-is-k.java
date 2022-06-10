class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0, j = 0; i < nums.length ; i++) {
            if(nums[i] - nums[j] > k){
                j = i;
                count += 1;
            }
        }
        return count;
    }
}