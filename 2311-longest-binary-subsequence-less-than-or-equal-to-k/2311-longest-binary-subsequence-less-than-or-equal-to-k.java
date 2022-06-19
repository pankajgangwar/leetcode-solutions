class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        s = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0'){
                dp[i] = new int[]{1,0};
            }else{
                dp[i] = new int[]{1,1};
            }
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                int currLen = dp[j][0];
                int currVal = dp[j][1];
                if(s.charAt(i) == '1' && currVal + Math.pow(2, currLen) <= k){
                    if(dp[i][0] < currLen + 1){
                        dp[i][0] = currLen + 1;
                        dp[i][1] = (int) (currVal + Math.pow(2, currLen));
                    }
                }else if(s.charAt(i) == '0' && currVal <= k){
                    if(dp[i][0] < currLen + 1){
                        dp[i][0] = currLen + 1;
                        dp[i][1] = currVal;
                    }
                }
                ans = Math.max(ans, dp[i][0]);
            }
        }
        return ans;
    }
}