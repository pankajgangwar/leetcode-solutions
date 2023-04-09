class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 4) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + n - 4 < n; i++) {
            min = Math.min(min, nums[i+n-4] - nums[i]);
        }
        return min;
    }
}