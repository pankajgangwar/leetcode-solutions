class Solution {
    public int longestSquareStreak(int[] nums) {
        TreeSet<Integer> sets = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        int maxLen = -1;
        while (!sets.isEmpty()){
            int min = sets.pollFirst();
            int len = 0;
            if(sets.contains(min * min)){
                len = 1;
                while (sets.contains(min * min)){
                    min *= min;
                    len += 1;
                }
            }
            if(len == 0) continue;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}