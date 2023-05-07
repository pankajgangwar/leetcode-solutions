class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
       int[] ans = new int[queries.length];
        int[] nums = new int[n];
        for (int i = 0, pairs = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int newCol = queries[i][1];
            int oldCol = nums[idx];
            if(idx-1 >= 0 && nums[idx-1] == newCol){
                pairs++;
            }
            if(idx+1 < n && nums[idx+1] == newCol){
                pairs++;
            }
            if(idx-1 >= 0 && nums[idx-1] == oldCol && oldCol != 0){
                pairs--;
            }
            if(idx+1 < n && nums[idx+1] == oldCol && oldCol != 0){
                pairs--;
            }
            nums[idx] = newCol;
            ans[i] = pairs;
        }
        return ans; 
    }
}