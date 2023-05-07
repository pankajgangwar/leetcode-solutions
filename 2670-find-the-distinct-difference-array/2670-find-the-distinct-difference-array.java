class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = n - 2; i >= 0; i--) {
            set.add(nums[i + 1]);
            suffix[i] = set.size();
        }
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }
        System.out.println(Arrays.toString(prefix) + " " + Arrays.toString(suffix));
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] - suffix[i];
        }
        return res;
    }
}