class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];
        while (low < high){
            int k = 0;
            int mid = (low + high) / 2;
            for (int i = 1; i < n && k < p; i++) {
                if(nums[i] - nums[i-1] <= mid){
                    k++;
                    i++;
                }
            }
            if(k >= p){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}