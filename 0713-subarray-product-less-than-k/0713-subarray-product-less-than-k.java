class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int p = 1;
        int count = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            p = p * nums[j];
            while(i <= j && p >= k){
                p /= nums[i++];
            }
            count += j - i + 1;
        }
        return count;
    }
}