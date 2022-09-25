class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == max){
                int j = i;
                int len = 0;
                while(j < n && nums[i] == nums[j]){
                    len++;
                    j++;
                }
                i = j - 1;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}