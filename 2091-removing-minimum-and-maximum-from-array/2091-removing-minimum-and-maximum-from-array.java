class Solution {
    
    public int minimumDeletions(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int n = nums.length;
        int minIndex = -1, maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if(nums[i] == max){
                maxIndex = i;
            }
            if(nums[i] == min){
                minIndex = i;
            }
        }
        int a = Math.min(minIndex, maxIndex);
        int b = Math.max(minIndex, maxIndex);
        
        return Math.min(a + 1 + n - b, Math.min(b + 1, n - a));
    }
    
}