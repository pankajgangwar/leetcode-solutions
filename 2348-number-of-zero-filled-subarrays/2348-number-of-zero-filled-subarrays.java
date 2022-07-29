class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int end = 0;
        int n = nums.length;
        while (end < n){
            int start = end;
            while (end < n && nums[end] == 0) end++;
            long len = end - start;
            long sum =  len * (len + 1) / 2;
            res += sum;
            end++;
        }
        return res;
    }
}