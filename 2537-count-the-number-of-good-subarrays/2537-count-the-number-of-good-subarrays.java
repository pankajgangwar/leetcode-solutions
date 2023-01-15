class Solution {
    public long countGood(int[] nums, int k) {
       long ans = 0, cnt = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            cnt += map.get(nums[j]) - 1;
            while (i < j && cnt >= k){
                ans += n - j;
                map.put(nums[i], map.get(nums[i]) - 1);
                cnt -= map.get(nums[i]);
                i++;
            }
        }
        return ans; 
    }
}