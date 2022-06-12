class Solution {
   
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0, curr = 0;
        for (int j = 0, i = 0; j < n; j++) {
            curr += nums[j];
            while (curr * (j - i + 1) >= k){
                curr -= nums[i++];
            }
            res += (j - i + 1);
        }
        return res;
    }
}