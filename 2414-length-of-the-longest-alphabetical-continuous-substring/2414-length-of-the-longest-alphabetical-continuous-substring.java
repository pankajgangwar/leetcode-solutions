class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if(n <= 0) return n;
        int len = 1, currLen = 1;
        for (int i = 0 ;  i < n - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            int idx1 = ch1 - 'a';
            int idx2 = ch2 - 'a';
            if(idx1 + 1 == idx2){
                currLen++;
            }else{
                len = Math.max(len, currLen);
                currLen = 1;
            }
        }
        len = Math.max(len, currLen);
        return len;
    }
}