class Solution {
        public boolean isMatch(String s, String p) {
        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        char[] str = s.toCharArray();
         int writeIndex = 0;
         boolean isFirst = true;
         char[] pattern = p.toCharArray();
         for ( int i = 0 ; i < pattern.length; i++) {
             if (pattern[i] == '*') {
                 if (isFirst) {
                     pattern[writeIndex++] = pattern[i];
                     isFirst = false;
                 }
             } else {
                 pattern[writeIndex++] = pattern[i];
                 isFirst = true;
             }
         }
            
        char[] newPattern = Arrays.copyOf(pattern, writeIndex);
        System.out.println(new String(newPattern) );

        boolean[][] dp = new boolean[str.length +1][writeIndex+1];

        if(writeIndex > 0 && p.charAt(0) == '*'){
            dp[0][1] = true;
        }
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length ; j++ ) {
                if(pattern[j-1] == '?' || pattern[j-1] == str[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[str.length][writeIndex];
    }
}