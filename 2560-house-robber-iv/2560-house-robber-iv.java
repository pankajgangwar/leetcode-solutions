class Solution {
    //mini-max problem
    public int minCapability(int[] nums, int k) {
        int low = 0;
        int high = (int)1e9;
        while(low < high){
            int mid =  (high + low)/2;
            if(isValid(nums, mid, k)){
                high = mid; // minimize the maximum capability
            } else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isValid(int[] a, int mid, int k){
        int take = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] <= mid){
                take += 1;
                i += 1; // Leaving adjacent house
            }
        }
        return take >= k;
    }
    
}