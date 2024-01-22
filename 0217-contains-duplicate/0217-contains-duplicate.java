class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mSet = new HashSet<Integer>();
        
        for(int i =0 ; i < nums.length; i++){
            if(!mSet.add(nums[i])){
                return true;
            }
        }
        
        return false;
    }
}