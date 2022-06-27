class Solution {
    public int distinctSequences(int n) {
        dp = new long[7][7][n+1];
        return (int)helper(n, -1, -1);
    }

    long[][][] dp;
    public long helper(int n, int prevLast, int last){
        if(n == 0) return 1;
        long mod = (long)1e9+7;
        long res = Math.min(prevLast, last) < 0 ? -1 : dp[last][prevLast][n];
        if(res > 0) return res;
        res = 0;
        for (int curr = 1; curr <= 6; curr++) {
            if(curr == prevLast || curr == last || (last != -1 && gcd(last, curr) != 1)) continue;
            res += (helper(n - 1, last, curr) + mod) % mod;
        }
        if(Math.min(prevLast, last) >= 0){
            dp[last][prevLast][n] = res % mod;
        }
        return res % mod;
    }
    
    public int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}