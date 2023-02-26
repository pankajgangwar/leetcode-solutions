class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                for(int k = j, min = height[j]; k >= 0 && min > 0; k--){
                    min = Math.min(min, height[k]);
                    ans += min;
                }
            }
        }
        return ans;
    }
}