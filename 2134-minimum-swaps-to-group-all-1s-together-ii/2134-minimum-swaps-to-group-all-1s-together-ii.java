class Solution {
    public int minSwaps(int[] nums) {
        int count = 0;
        for(int n : nums) count += n;
        int n = nums.length;
        int window = 0;
        for (int i = 0; i < count; i++) {
            window += nums[i] == 0 ? 1 : 0;
        }
        int min = window;
        for (int end = count, start = 0; end < n + count ; end++, start++) {
            window -= nums[start % n] == 0 ? 1 : 0;
            window += nums[end % n] == 0 ? 1 : 0;
            min = Math.min(min, window);
        }
        return min;
    }
}