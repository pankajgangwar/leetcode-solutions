class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0, xor = 0;
        Map<Long, Long> freqMap = new HashMap<>();
        freqMap.put(0L, 1L);
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            ans += freqMap.getOrDefault(xor, 0L);
            freqMap.put(xor, freqMap.getOrDefault(xor, 0L) + 1);
        }
        return ans;
    }
}