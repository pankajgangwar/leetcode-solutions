class Solution {
   long power(long base,long n,long mod) {
            long res = 1;
            while (n > 0) {
                if (n % 2 == 1){
                    res = (res * base) % mod;
                }
                n = n >> 1;
                base = (base * base) % mod;
            }
            return res % mod;
        }

        int monkeyMove(int n) {
            int mod =(int)1e9+7;
            return (int)(power(2,n,mod)+mod-2)%mod;
        }
}