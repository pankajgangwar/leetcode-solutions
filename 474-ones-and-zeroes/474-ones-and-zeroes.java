class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //return findMaxFormRec(strs, m, n, 0);
        
        /*int[] memo = new int[strs.length  +1];
        Arrays.fill(memo, -1);
        return findMaxFormMemo(strs, m, n, 0, memo);*/
        return findMaxFormDP(strs, m, n);
        
    }
    
     public int findMaxFormDP(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int l = strs.length;

        for (int i = 0; i < l + 1; i++) {
            int[] nums = new int[]{0, 0};
            if(i > 0 ){
                nums = count(strs[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if(i == 0){
                        dp[i][j][k] = 0;
                    }else if(j >= nums[0] && k >= nums[1]){
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j - nums[0]][k - nums[1]] + 1 );
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }

                }
            }
        }
        return dp[l][m][n];
    }
    
     public int[] count(String str){
        int[] freq = new int[2];

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            freq[digit]++;
        }
        return freq;
    }
    
    public int findMaxFormMemo(String[] strs, int m, int n, int idx, int[] memo) {
        if(idx == strs.length || (m + n == 0 )){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int totalStringWithCurr = 0;
        String curr = strs[idx];
        int zero = countZeros(curr);
        int ones = curr.length() - zero;

        if(m >= zero && n >= ones){
            totalStringWithCurr = 1 + findMaxFormRec(strs, m - zero, n - ones, idx + 1);
        }

        int totalStringWithoutCur = findMaxFormRec(strs, m, n, idx + 1);

        int max =  Math.max(totalStringWithCurr, totalStringWithoutCur);
        memo[idx] = max;
        return memo[idx];
    }
    
    public int findMaxFormRec(String[] strs, int m, int n, int idx) {
         if(idx == strs.length || (m + n == 0 )){
            return 0;
        }

        int totalStringWithCurr = 0;
        String curr = strs[idx];
        int zero = countZeros(curr);
        int ones = curr.length() - zero;

        if(m >= zero && n >= ones){
            totalStringWithCurr = 1 + findMaxFormRec(strs, m - zero, n - ones, idx + 1);
        }

        int totalStringWithoutCur = findMaxFormRec(strs, m, n, idx + 1);

        return Math.max(totalStringWithCurr, totalStringWithoutCur);
    }
    
     public int countZeros(String str){
        int zeros = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0')
                zeros++;
        }
        return zeros;
    }

}