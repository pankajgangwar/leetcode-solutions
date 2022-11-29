class Solution {
    public boolean isSubsequence(String s, String t) {
        //int length = subSequenceDP(s.toCharArray(), t.toCharArray());
        //return length == s.length();
		boolean res = isSubSequence(s, t);
		return res;
    }

    public boolean isSubSequence(String s, String t){
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()){
			if(s.charAt(i) == t.charAt(j)){
				i++;
			}
			j++;
		}
		return i == s.length();
	}
    
     public int subSequence(char s[], char t[]) {
         int m = s.length;
         int n = t.length;
         
         int dp[][] = new int[m + 1][ n + 1];
         
         for(int i = 1 ; i <= m; i++ ) {
             for(int j = 1; j <= n; j++ ) {
                 if(s[i-1] == t[j-1]){
                     dp[i][j] = 1 + dp[i-1][j-1];
                 } else {
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                 }
             }
         }
         return dp[m][n];
    }
    
}