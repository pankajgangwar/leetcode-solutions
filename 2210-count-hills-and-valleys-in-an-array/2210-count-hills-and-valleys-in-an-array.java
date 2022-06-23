class Solution {

    public int countHillValley(int[] nums) {
        int res = 0;
        int n = nums.length;
        int left = nums[0], right = 0;
        for (int i = 1; i < n-1; i++) {
            int a = nums[i];
            if(left < a && a > nums[i+1] || left > a && a < nums[i+1]){
                res++;
                left = nums[i];
            }
        }
        return res;
    }
}
