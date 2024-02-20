class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        
        //n--;
        long actualSum = (n * (n + 1)) / 2;
        return (int)(actualSum - sum);
    }
}