class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && strength[st.peek()] > strength[i]){
                right[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();
        for (int i = n-1 ; i >= 0; i--) {
            while (!st.isEmpty() && strength[st.peek()] >= strength[i]){
                left[st.pop()] = i;
            }
            st.push(i);
        }
        long res = 0;
        long[] pref = new long[n];
        int mod = (int)1e9+7;
        for (int i = 0; i < n; i++) {
            pref[i] = strength[i];
            if(i > 0){
                pref[i] = (pref[i-1] + pref[i])%mod;
            }
        }
        long[] prefpref = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            prefpref[i] = (prefpref[i-1] + pref[i-1]) % mod;
        }
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            long lSum = prefpref[i] - prefpref[Math.max(l, 0)];
            long rSum = prefpref[r] - prefpref[i];
            res = (res + strength[i] * (rSum * (i-l) % mod - lSum *(r - i) % mod)) % mod;
        }
        return (int)(res + mod) % mod;
    }
}