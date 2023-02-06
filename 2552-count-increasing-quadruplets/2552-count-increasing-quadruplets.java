class Solution {
    public long countQuadruplets(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[][] left = new int[n][n + 1];
        int[][] right = new int[n][n + 1];
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= n; j++){
                left[i][j] = left[i - 1][j];
            }
            for(int j = nums[i - 1] + 1; j <= n; j++){
                left[i][j]++;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= n; j++){
                right[i][j] = right[i + 1][j];
            }
            for(int j = 0; j < nums[i + 1]; j++){
                right[i][j]++;
            }
        }
        for(int j = 0; j < n; j++){
            for(int k = j + 1; k < n; k++){
                if(nums[j] <= nums[k]) continue;
                res += (long) left[j][nums[k]] * right[k][nums[j]];
            }
        }
        return res;
    }
}