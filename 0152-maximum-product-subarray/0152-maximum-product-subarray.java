class Solution {
    public int maxProductI(int[] nums) {
        if(nums.length == 0) return -1;
        int curr_max = nums[0];
        int global_max = nums[0];
        int curr_min = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = curr_max;
            curr_max = Math.max(Math.max(curr_max * nums[i], curr_min * nums[i]), nums[i]);
            curr_min = Math.min(Math.min(temp * nums[i], curr_min * nums[i]), nums[i]);
                
            if(global_max < curr_max){
                global_max = curr_max;
            }
        }
        return global_max;
    }
    
     public int maxProduct(int[] nums) {
         return maxProductIII(nums);
     }
    
    public int maxProductIII(int[] nums) {
        int n = nums.length;
        int r = nums[0];
        for(int i = 1, max = r, min = r; i < n; i++ ){
            if(nums[i] < 0){  // multiplied by a negative makes big number smaller, small number bigger
                int tmp = min;
                min = max;
                max = tmp;            
            }

            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);

            r = Math.max(r, max);
        }
        return r;
    }
    
    public int maxProductII(int[] nums) {
        int r = 0;
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];

        prefixProd[0] = nums[0];
        suffixProd[n-1] = nums[n-1];
        
        r = nums[0];

        for(int i = 1; i < n; i++){
            prefixProd[i] = (prefixProd[i - 1] == 0 ? 1 : prefixProd[i-1]) * nums[i];
        }

        for(int i = n-2; i >= 0; i--){
            suffixProd[i] = (suffixProd[i + 1] == 0 ? 1 : suffixProd[i + 1]) * nums[i];
        }

        for(int i = 0; i < n; i++){
            r = Math.max(r, Math.max(suffixProd[i], prefixProd[i]));
        }
        return r;
    }
}