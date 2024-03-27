class Solution {
    
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            //System.out.println(" slow " + slow + " fast "  + fast);
            
        }
        slow = 0;
        //System.out.println(" **** fast "  + fast);
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}