class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        String res = "";
        for (int i = 0, j = 0; i <= n; i++) {
            res += (i+1);
            if(i == n || pattern.charAt(i) == 'I'){
                String s = new StringBuilder(res.substring(j, (i+1))).reverse().toString();
                res = res.substring(0, j);
                res += s;
                j = i + 1;
            }
        }
        return res;
    }
}