class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Long, Long> goodPairsMap = new HashMap<>();
        
        int n = nums.length;
        long goodPairs = 0L;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n; i++){
            String rev = new StringBuilder(String.valueOf(nums[i])).reverse().toString();
            long diff = (long)nums[i] - Long.parseLong(rev);
            
            goodPairs += goodPairsMap.getOrDefault(diff, 0L);
            goodPairs %= mod;
            goodPairsMap.put(diff, goodPairsMap.getOrDefault(diff, 0L) + 1L);
        }
        return (int)(goodPairs);
    }
}