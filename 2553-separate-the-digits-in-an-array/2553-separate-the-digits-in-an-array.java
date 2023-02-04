class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            out.append(n);
        }
        int[] res = new int[out.length()];
        for (int i = 0; i < out.length(); i++) {
            res[i] = out.charAt(i) - '0';
        }
        return res;
    }
}