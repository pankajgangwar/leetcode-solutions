class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[26];
        int res = 0;
        for (int ci = 0; ci < n; ci++) {
            int curr = 0, i = s.charAt(ci) - 'a';
            for (int j = Math.max(0, i - k); j <= Math.min(25, i + k); j++) {
                curr = Math.max(curr, dp[j] + 1);
            }
            dp[i] = curr;
            res = Math.max(res, curr);
        }
        return res;
    }
}