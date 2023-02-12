class Solution {
    public int minimumScore(String s, String t) {
        int res = 0;
        int nt = t.length();
        int ns = s.length();
        int[] dp = new int[nt];
        Arrays.fill(dp, -1);
        int k = nt - 1;
        for (int i = ns-1 ; i >= 0 && k >= 0 ; --i) {
            if(t.charAt(k) == s.charAt(i)){
                dp[k--] = i;
            }
        }
        res = k + 1;
        for(int i = 0, j = 0; i < ns && j < nt && res > 0; ++i){
            if(s.charAt(i) == t.charAt(j)){
                for(; k < nt && dp[k] <= i; ++k);
                res = Math.min(res, k - (++j));
            }
        }
        return res;
    }
}