class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int res = max;
        while (k-- > 1){
            max += 1;
            res += max;
        }
        return res;
    }
}