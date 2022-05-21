class Solution {
    public int wiggleMaxLengthI(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int [] up = new int[n];
        int [] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(down[n-1], up[n-1]);
    }
    
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        int [] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = nums[i] - nums[i+1];
            res[i] = diff;
        }
        int i = 0;
        while (i < n - 1 && res[i] == 0){
            i++;
        }
        if(i == n - 1) return 1;
        
        int prev = res[i];
        int maxlen = 1; // Add 1 for first ele as res stores difference of two numbers
        for (; i < n; i++) {
            if(res[i] < 0 && prev >= 0){
                maxlen++;
                prev = res[i];
            }else if(res[i] > 0 && prev < 0){
                maxlen++;
                prev = res[i];
            }
        }
        return maxlen + 1; // Add 1 to res as i starts at index 1
    }
}