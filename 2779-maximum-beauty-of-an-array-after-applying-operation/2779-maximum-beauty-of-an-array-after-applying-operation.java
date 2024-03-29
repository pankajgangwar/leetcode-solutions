class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = 0 ; j < n; j++) {
            while (j < n && nums[j] - nums[i] <= (k * 2)){
                j++;
            }
            ans = Math.max(ans, (j - i));
            i++;
        }
        return ans;
    }
}