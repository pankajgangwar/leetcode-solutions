class Solution {
    public int maxSubarrayLength(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Integer higher =  map.higherKey(nums[i]);
            if(higher == null){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }
            }else{
                res = Math.max(res, i - map.get(higher) + 1);
            }
        }
        return res;
    }
}