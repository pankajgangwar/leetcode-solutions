class Solution {

    public int countDistinct(String s) {
        long BASE = 100007L, MOD = (long) (1e11 + 7);
        int n = s.length();
        long[] pow = new long[n + 10];
        pow[0] = 1;
        for (int i = 1; i <= n; ++i) {
            pow[i] = (pow[i - 1] * n) % MOD;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                //System.out.println(sub);
                long H = 0L;
                /*for (int k = 0; k < sub.length(); k++) {
                    H += ((sub.charAt(k) - 'a') * pow[n - 1 - k]) % MOD;
                    H %= MOD;
                }*/
                set.add(sub);
            }
        }
        return set.size();
    }
}
