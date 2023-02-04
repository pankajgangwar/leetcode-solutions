class Solution {
    public int maximizeWin(int[] arr, int k) {
        int n = arr.length;
        int res = 0, j = 0;
        int[]dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            while (arr[i] - arr[j] > k) {
                ++j;
            }
            dp[i + 1] = Math.max(dp[i], i - j + 1);
            res = Math.max(res, i - j + 1 + dp[j]);
        }
        return res;
    }
}