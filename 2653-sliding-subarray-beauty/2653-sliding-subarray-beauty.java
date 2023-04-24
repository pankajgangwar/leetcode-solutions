class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] counter = new int[50];
        for (int i = 0; i < n ; i++) {
            if(nums[i] < 0) counter[nums[i] + 50]++;
            if(i - k >= 0) {
                if(nums[i - k] < 0) counter[nums[i - k] + 50]--;
            }
            if(i - k + 1 < 0) continue;
            for(int j = 0, count = 0; j < counter.length; j++){
                count += counter[j];
                if(count >= x){
                    ans[i - k + 1] = j - 50;
                    break;
                }

            }
        }
        return ans;
    }

    
}