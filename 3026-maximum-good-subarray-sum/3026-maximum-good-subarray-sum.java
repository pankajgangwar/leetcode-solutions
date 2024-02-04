class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        Map<Integer, Long> map = new HashMap<>();
        
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i - 1];
        }

        long sum = 0l;
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(nums[i], Long.MAX_VALUE) > prefix[i]) {
                map.put(nums[i], prefix[i]);
            }
            sum += nums[i];
            if (map.containsKey(nums[i] + k)) {
                maxSum = Math.max(maxSum, prefix[i+1] - map.get(nums[i] + k));
            }
            if (map.containsKey(nums[i] - k)) {
                maxSum = Math.max(maxSum, prefix[i+1] - map.get(nums[i] - k));
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}