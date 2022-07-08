class Solution {
     public int countVowelStrings(int n) {
        //return dfs(n, new ArrayList<Character>());
         return dp(n);
    }
    
    public int dp(int n){
        //dp[n][k] means the number of strings constructed by at most k different characters.
        int[][] dp = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 5; k++) {
                dp[i][k] += dp[i][k-1] + (i > 1 ? dp[i-1][k] : 1);
            }
        }
        return dp[n][5];
    }

    public int dfs(int n, ArrayList<Character> list){
        if(list.size() == n) return 1;
        char[] arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!list.isEmpty() && list.get(list.size()-1) > arr[i])continue;
            list.add(arr[i]);
            count += dfs(n, list);
            list.remove(list.size()- 1);
        }
        return count;
    }

}