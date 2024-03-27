class Solution {
    
    public int binarySearch(int[] nums) {
        int n = nums.length;
        
        int low = 1, high = n;
        while(low < high){
            int mid = low + (high - low) / 2;
            //System.out.println(" mid " + mid);
            int cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += nums[i] <= mid ? 1 : 0;
            }
            if(cnt > mid){
                high = mid;
            }else{
                low = mid + 1;                
            }
        }
        return high; 
    }
    
     public int findDuplicate(int[] nums) {
         return binarySearch(nums);
     }
    
    public int findDuplicateSlowFast(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}