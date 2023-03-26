class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] pref = new long[n + 1];
        for(int i = 1; i <= n; i++){
            pref[i] = pref[i - 1] + nums[i - 1];
        }
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i];
            int idx = Arrays.binarySearch(nums, x);
            if(idx < 0) idx = ~idx;
            long sum = ((long) x * idx) - (pref[idx]);
            sum += (pref[n] - pref[idx]) - ((long) x * (n - idx));
            ans.add(sum);
        }
        return ans;
    }
}