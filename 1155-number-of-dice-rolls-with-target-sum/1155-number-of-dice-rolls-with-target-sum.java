class Solution {
    public int numRollsToTarget(int d, int f, int target) {
       return findWays(f, d, target);
    }
    
    public static int findWays(int m, int n, int target){

        int[][] table = new int[n+1][target+1];
        int mod = 1000000007;

        for(int j = 1; j <= m && j <= target; j++)
            table[1][j] = 1;

        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= target; j++){
                for(int k = 1; k < j && k <= m; k++){
                    table[i][j] += table[i-1][j-k];
                     if(table[i][j] > mod) table[i][j] = table[i][j] % mod;
                }
            }
        }
        return table[n][target];
    }
}