class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int)1e9+7;
        Arrays.sort(nums);
        int l = 0, n = nums.length, r = n - 1;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        int res = 0;
        while (l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            }else{
                res = (res + pow[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}