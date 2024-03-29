class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        if(map.get(max) < k) return 0;

        int start = 0, end = 0, count = 0;
        int n = nums.length;
        for (; end < n ; end++) {
            if(nums[end] == max) count++;
            while(count >= k){
                count -= nums[start++]  == max ? 1 : 0;
               res += n - end; 
            }
            //res += start;
        }
        return res;
    }
}