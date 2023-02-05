class Solution {
    //mini-max problem
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        while(low < high){
            int mid =  (high + low)/2;
            if(isValid(nums, mid, k)){
                high = mid;
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
    
    public int solveRec(int[] a, int k, int i, int[] dp){
            if(i>=a.length){
                return 0;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            int nt = solveRec(a,k,i+1,dp);
            if(a[i] <= k){
                return dp[i] = Math.max(solveRec(a,k,i+2,dp)+1,nt);
            }
            return dp[i] = nt;
        }
}