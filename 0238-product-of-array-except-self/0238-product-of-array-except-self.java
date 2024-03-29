class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        
        for(int i=1; i < n; i++){
            left[i] = nums[i-1] * left[i-1];
        }
        
        for(int j=n-2; j >= 0; j--){
            right[j] = nums[j+1] * right[j+1];
        }
        
        System.out.println("left " + Arrays.toString(left) + " right " + Arrays.toString(right));
        for(int k=0; k<n; k++){
            prod[k] = left[k] * right[k];
        }
        
        return prod;
        
    }
}