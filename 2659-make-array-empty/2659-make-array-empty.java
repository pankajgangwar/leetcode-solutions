class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        long res = n;
        for (int i = 1; i < n; i++) {
            if(map.get(nums[i]) < map.get(nums[i-1])){
                res += n - i;
            }
        }
        return res;
    }
}