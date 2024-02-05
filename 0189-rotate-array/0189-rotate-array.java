class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        /*if(k > nums.length){
            k = k - nums.length;
        }*/
        int len = nums.length;
        int rotation_point = len - k;
        
        int start = rotation_point;
        int end = len - 1; 
        
        reverse(nums, start, end);
        
        start = 0;
        end = rotation_point - 1;
        
        reverse(nums, start, end);
        
        start = 0;
        end = len - 1;
        
        reverse(nums, start, end);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}