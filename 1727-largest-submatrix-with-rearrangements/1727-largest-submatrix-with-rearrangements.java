class Solution {
  public int largestSubmatrix(int[][] matrix) {
      int n = matrix[0].length;
        int ans = 0;
        int[] hist = new int[n];
        for (int[] row : matrix) {
            for (int i = 0; i < n; i++) {
                hist[i] = row[i] == 0 ? 0 : hist[i] + 1;
            }
            int[] cloneHist = hist.clone();
            Arrays.sort(cloneHist);
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, cloneHist[i] * (n - i));
            }
        }
        return ans;
  }
}