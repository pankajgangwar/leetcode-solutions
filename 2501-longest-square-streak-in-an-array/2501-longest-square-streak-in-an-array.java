class Solution {
    
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int[] a = uniq(nums);
        int n = a.length;
        int[]dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int q = (int)Math.sqrt(a[i]);
            dp[i] = 1;
            if(q*q == a[i]){
                int idx = Arrays.binarySearch(a, q);
                if(idx >= 0){
                    dp[i] = dp[idx] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans == 1 ? -1 : ans;
    }

    public int[] uniq(int[] nums){
        if(nums.length == 0) return nums;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]) nums[p++] = nums[i];
        }
        return Arrays.copyOf(nums, p);
    }
    
    public int longestSquareStreak1(int[] nums) {
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