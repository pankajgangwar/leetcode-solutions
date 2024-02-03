class Solution {
    public int numRollsToTarget(int d, int f, int target) {
       return findWays(f, d, target);
    }
    
     public static int findWays(int faces, int n, int target){
        int[][] table = new int[n+1][target+1];
        int mod = (int)1e9+7;
        for(int j = 1; j <= faces && j <= target; j++)
            table[1][j] = 1;
         
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int k = 1; k < j && k <= faces; k++){
                    table[i][j] += table[i-1][j-k];
                    table[i][j] %= mod;
                }
            }
        }
        return table[n][target];
    }
}