class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxi = nums[0], maxij = nums[0] - nums[1];
        long prod = 0;
        for (int k = 2; k < n; k++) {
             prod = Math.max(prod, maxij * nums[k]);
             maxi = Math.max(maxi, nums[k-1]);
             maxij = Math.max(maxij, maxi - nums[k]);
        }
        return prod < 0 ? 0 : prod;
    }
}