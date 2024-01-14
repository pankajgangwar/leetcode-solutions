class Solution {
    int mod = 1000000007;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        if(k > 26) return 0;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        long res = 1;
        int required = 0, totalPresent = 0;
        for(int i = 0; i < k; i++){
            res = res * freq[25 - i];
            res = res % mod;
            if(freq[25 - i] == freq[25 - (k - 1)]){
                required++;
            }
        }
        for (int i : freq){
            if(i == freq[25 - ( k - 1)]){
                totalPresent++;
            }
        }
        res *= choose(totalPresent, required);
        res %= mod;
        return (int)res;
    }

    private long choose(int n, int k) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= mod;
        }
        for (int i = 1; i <= k; i++) {
            res *= mInv(i);
            res %= mod;
        }
        for (int i = 1; i <= (n - k); i++) {
            res *= mInv(i);
            res %= mod;
        }
        return res;
    }

    private long mInv(int n) {
        return mPow(n, mod - 2);
    }

    private long mPow(int n, int p) {
        long res = 1, pow = n;
        while (p > 0){
            if(p % 2 == 1){
                res *= pow;
                res %= mod;
            }
            pow *= pow;
            pow %= mod;
            p >>= 1;
        }
        return (int)res;
    }
}