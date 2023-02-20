class Solution {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < 31; i++) {
            if (!set.contains(1 << i)) { // minimum power of 2
                return 1 << i;
            }
        }
        return -1;
    }
}