class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int curr = 0;
                for (int i = 0; i < m ; i++) {
                    curr += matrix[i][k] - (j > 0 ? matrix[i][j - 1] : 0);
                    ans += map.getOrDefault(curr - target, 0);
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                }
            }
        }
        return ans;
    }
}