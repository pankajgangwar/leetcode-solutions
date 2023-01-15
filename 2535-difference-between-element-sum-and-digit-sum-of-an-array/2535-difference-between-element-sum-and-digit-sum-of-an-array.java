class Solution {
    public int differenceOfSum(int[] nums) {
        int n = nums.length;
        int elementSum = 0, digitSum = 0;
        for (int i = 0; i < n; i++) {
            elementSum += nums[i];
            int a = nums[i];
            while (a > 0){
                digitSum += a % 10;
                a = a / 10;
            }
        }
        return Math.abs(elementSum - digitSum);
    }
}