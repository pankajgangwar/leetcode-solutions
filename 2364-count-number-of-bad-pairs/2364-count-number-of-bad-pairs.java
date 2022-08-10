class Solution {
    public long countBadPairs(int[] nums) {
        long goodPairs = 0l;
        HashMap<Long, Long> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long a = i - nums[i];
            goodPairs += map.getOrDefault(a, 0l);
            map.put(a, map.getOrDefault(a, 0l) + 1);
        }
        long total = (long) n * (n  - 1) / 2;
        return total - goodPairs;
    }
}