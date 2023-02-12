class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    public long countLess(int[] nums, int val){
        int n = nums.length;
        long res = 0;
        for (int i = 0, j = n -1; i < j; i++) {
            while(i < j && nums[i] + nums[j] > val) --j;
            res += j - i;
        }
        return res;
    }
}