class Solution {

    public int minimumTimeToInitialState(String s, int k) {
        int n = s.length(), v = 0, dp[] = new int[n];
        for (int i = 1; i < n; i++) { // kmp
            while (v > 0 && s.charAt(i) != s.charAt(v)) {
                v = dp[v - 1];
            }
            v = dp[i] = v + (s.charAt(i) == s.charAt(v) ? 1 : 0);
        }
        while (v > 0 && (n - v) % k > 0) {
            v = dp[v - 1];
        }
        return (n - v + k - 1) / k;
    }
}
