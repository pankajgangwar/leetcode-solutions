class Solution {
    
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long per = Arrays.stream(nums).summaryStatistics().getSum();
        
        long largest = 0;
        for(int i = n - 1; i >= 2; --i){
            largest = nums[i];
            if(largest < per - largest) return per;
            per -= largest;
        }
        return -1;
    }
    
    public long largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long per = 0L;
        long sum = nums[0] + nums[1];
        for(int i = 2; i < n; i++){
            if(sum > nums[i]){
                per = sum + nums[i];
            }
            sum += nums[i];
        }
        return per == 0 ? -1 : per;
    }
}