class Solution {
     int dp[];
    public void fill_dp(int n){
         dp = new int[n+1];
         dp[0] = 0;
         dp[1] = 1;
         dp[2] = 1;
    }

    public int call_tribonacci(int n){
        if(n == 0 ){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }
        fill_dp(n);
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    public int tribonacci(int n) {
        return call_tribonacci(n);
    }
}