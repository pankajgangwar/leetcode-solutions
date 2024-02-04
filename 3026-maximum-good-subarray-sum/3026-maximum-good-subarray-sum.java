class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        Map<Integer, Long> map = new HashMap<>();

        long sum = 0l;
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(nums[i], Long.MAX_VALUE) > sum) {
                map.put(nums[i], sum);
            }
            sum += nums[i];
            if (map.containsKey(nums[i] + k)) {
                maxSum = Math.max(maxSum, sum - map.get(nums[i] + k));
            }
            if (map.containsKey(nums[i] - k)) {
                maxSum = Math.max(maxSum, sum - map.get(nums[i] - k));
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}