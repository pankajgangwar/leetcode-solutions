class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, n = nums.length;
        int end = 0, start = 0;
        while(end < n){
            
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            while(map.getOrDefault(nums[end], 0) > k){
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}