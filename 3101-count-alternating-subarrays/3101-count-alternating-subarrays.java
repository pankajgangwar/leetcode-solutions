class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long ans = n;
        if (n == 1) return ans;
        int prev = nums[0];
        for (int i = 1, count = 0; i < n; i++) {
            if(prev != nums[i]){
                count++;
                ans += count;
            }else{
                count = 0;
            }
            prev = nums[i];
        }
        return ans;
    }
}