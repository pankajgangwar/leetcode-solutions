class Solution {
    int max = 1000;
    int[][] memo;
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n*m == 0){
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0; i < n + 1; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i < m + 1; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(word1.charAt(i -1) == word2.charAt(j -1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + minOfEditOperations(dp[i-1][j], dp[i][j-1],dp[i-1][j-1]);
                }
            }   
        }
        return dp[n][m];
    }

    public int minOfEditOperations(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
    
    public int minDistanceMemo(String word1, String word2) {
        //return editDistance(word1, word2, word1.length(), word2.length());
        
        memo = new int[word1.length()][max];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return editDistanceMemo(word1, word2, word1.length(), word2.length(), memo);
    }
    
    public int editDistanceMemo(String str1, String str2, int m, int n, int[][] memo){
        if(m == 0)
            return n;

        if(n == 0)
            return m;

        if(memo[m-1][n-1] != -1){
            return memo[m-1][n-1];
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return memo[m-1][n-1] = editDistanceMemo(str1, str2, m-1, n-1, memo);
        }

        return memo[m-1][n-1] = 1 + min_op(editDistanceMemo(str1, str2, m, n-1, memo),//Insert
                editDistanceMemo(str1, str2, m-1, n, memo), //Remove
                editDistanceMemo(str1, str2, m-1, n-1, memo)); //Replace
    }
    
    public int editDistance(String str1, String str2, int m, int n){
        if(m == 0) return n;//If srt2 is empty, insert all chars to str2
        if(n == 0) return m;// If str1 is empty, remove all chars from str1

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return editDistance(str1, str2, m-1, n-1);
        }
        return 1 + min_op(editDistance(str1, str2, m, n-1),
                editDistance(str1, str2, m-1, n),
                editDistance(str1, str2, m-1, n-1));
    }
    
    public int min_op(int x, int y, int z){
       int min_a = Math.min(x,y);
       return Math.min(min_a,z);
    }
}