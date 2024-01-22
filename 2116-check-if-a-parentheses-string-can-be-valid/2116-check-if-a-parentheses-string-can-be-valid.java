class Solution {
    public boolean canBeValid(String s, String l) {
        int n = s.length();
        if(n%2==1) return false;
        int canChange = 0, open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            if(l.charAt(i) == '0'){
                canChange++;
            }else if (s.charAt(i) == '(') {
                open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            if(canChange + open - close < 0) return false;
        }

        canChange = open = close = 0;
        for (int i = n-1; i >= 0; i--) {
            if(l.charAt(i) == '0'){
                canChange++;
            }else if (s.charAt(i) == '(') {
                open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            if(canChange - open + close < 0) return false;
        }
        return true;
    }
}