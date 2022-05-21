class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long[] prefix = new long[n];
        int d = s.charAt(0) - '0';
        prefix[0] = d;
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prefix[i] = digit + prefix[i - 1];
        }
        long ways = 0;
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if(digit == 0){
                ways += prefix[i - 1] * (prefix[n - 1] - prefix[i]);
            }else{
                long leftzero = i - prefix[i - 1];
                long rightZero = (n - i - 1) - (prefix[n - 1] - prefix[i]);
                ways += (leftzero * rightZero);
            }
        }
        return ways;
    }
}