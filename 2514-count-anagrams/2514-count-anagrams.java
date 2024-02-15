class Solution {
    int mod = (int)1e9 + 7;
    public int countAnagrams(String s) {
        int n = s.length();
        String[] arr = s.split(" ");
        long[] fact = new long[n + 1];
        fact[0] = 1L;
        
        for(int i = 1; i <= n; i++){
            fact[i] = (fact[i-1] * i ) % mod;
        }
        long ans = 1L;
        for(String a : arr){
            int[] freq = new int[26];
            for(char ch : a.toCharArray()){
                freq[ch - 'a']++;
            }
            long curr = 1L;
            for(int x : freq){
                curr = curr * fact[x] % mod;
            }
            curr = fact[a.length()] * binpow(curr, mod - 2) % mod;
            ans = ans * curr % mod;
        }
        return (int)ans;
    }

    long binpow(long a, long b) {
        if (b == 0)
            return 1;
        long res = binpow(a, b / 2);
        res = res * res % mod;
        if (b % 2==1){
            return res * a % mod;
        } else {
            return res;
        }
    }
}