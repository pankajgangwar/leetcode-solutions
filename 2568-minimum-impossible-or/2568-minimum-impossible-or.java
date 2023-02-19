class Solution {
    public int minImpossibleOR(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < 31; i++) {
            if (!map.containsKey(1 << i)) {
                return 1 << i;
            }
        }
        return -1;
    }
}