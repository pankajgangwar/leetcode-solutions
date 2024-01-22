class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 4) return 0;
        int min = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i + n - 4 < n; i++) {
            System.out.println(nums[i] + "," + nums[i+n-4]);
            min = Math.min(min, nums[i+n-4] - nums[i]);
        }
        return min;
    }
}