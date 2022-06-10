class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int[] op : operations) {
            int a = op[0];
            int b = op[1];
            int idx = cache.get(a);
            cache.remove(a);
            nums[idx] = b;
            cache.put(b, idx);
        }
        return nums;
    }
}