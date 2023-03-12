class Solution {
    public long countSubarrays(int[] nums, int min, int max) {
        if(min == max){
            return forSameRange(nums, min);
        }
        long res = 0;
        boolean minFound = false, maxFound = false;
        int minStart = 0, maxStart = 0, start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min || nums[i] > max){
                minFound = maxFound = false;
                start = i + 1;
            }
            if(nums[i] == min){
                minFound = true;
                minStart = i;
            }
            if(nums[i] == max){
                maxFound = true;
                maxStart = i;
            }
            if(minFound && maxFound){
                res += Math.min(minStart, maxStart) - start + 1;
            }
        }
        return res;
    }
    
    private long forSameRange(int[] nums, int val) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long count = 0;
            while (i < nums.length && nums[i] == val){
                count += 1;
                i += 1;
            }
            res = ( count * (count + 1)) / 2;
        }
        return res;
    }

}