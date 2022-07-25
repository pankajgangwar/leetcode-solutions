class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        long[]cnt = new long[30];
        for(int n : sets){
            int bits = Integer.bitCount(n);
            ++cnt[bits];
        }
        long res = 0;
        for (int i = 1; i < 30 ; i++) {
            for (int j = 1; j < 30; j++) {
                if(i + j >= k){
                    res += cnt[i] * cnt[j];
                }
            }
        }
        return res;
    }
}