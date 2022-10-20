class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        int minmax = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //minmax = (int) Math.max(minmax, (sum + i) / (i + 1));
            minmax = (int) Math.max(minmax, Math.ceil(sum / (double)(i + 1)));
        }
        return minmax;
    }
}