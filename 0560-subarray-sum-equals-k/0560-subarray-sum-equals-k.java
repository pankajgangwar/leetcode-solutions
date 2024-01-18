class Solution {
    public int subarraySum(int[] nums, int target) {
       Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        prefixSumMap.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(prefixSumMap.containsKey(sum - target)){
                count += prefixSumMap.get(sum - target);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0)  +1);
        }
        return count;
    }
    
}