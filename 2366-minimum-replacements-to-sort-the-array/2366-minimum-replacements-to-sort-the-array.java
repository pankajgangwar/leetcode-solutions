class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        int prev = nums[n - 1];
        long ans = 0;
        for (int i = n - 2; i >= 0 ; i--) {
            int curr = nums[i];
            if(curr % prev == 0){
                ans += curr / prev - 1;
            }else if(curr < prev){
                prev = curr;
            }else{
                int div = (curr + prev - 1) / prev;
                ans += div - 1;
                prev = curr / div;
            }
        }
        return ans;
    }
}