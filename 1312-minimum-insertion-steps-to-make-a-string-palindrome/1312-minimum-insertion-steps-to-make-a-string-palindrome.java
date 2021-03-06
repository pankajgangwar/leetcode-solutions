class Solution {
    public int minInsertions(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(memo[i], -1);
        }
        //return minInsertionsRec(s, 0, s.length()-1);
     // return minInsertionsMemo(s, 0, s.length()-1, memo);
        return minInsertionsDp(s);
    }
    
     private int minInsertionsDp(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(s.charAt(i) == s.charAt(n-j-1)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return n - dp[n][n];
    }
    
    public int minInsertionsMemo(String s, int i, int j, int[][] memo){
        if(i >= j){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = minInsertionsMemo(s, i+1, j-1, memo);
        }else{
             memo[i][j] = 1 + Math.min(minInsertionsMemo(s, i+1, j, memo), minInsertionsMemo(s, i, j-1, memo));
        }
        return memo[i][j];
    }

    public int minInsertionsRec(String s, int i, int j){
        if(i >= j){
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)){
            return minInsertionsRec(s, i+1, j-1);
        }else{
            return 1 + Math.min(minInsertionsRec(s, i+1, j), minInsertionsRec(s, i, j-1));
        }
    }
}