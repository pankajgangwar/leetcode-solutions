class Solution {
    public boolean canBeValid(String s, String l) {
        int n = s.length();
        if(n%2==1) return false;
        int tot = 0, op = 0, cl = 0;
        for (int i = 0; i < n; i++) {
            if(l.charAt(i) == '0'){
                tot++;
            }else if (s.charAt(i) == '(') {
                op++;
            }else if(s.charAt(i) == ')'){
                cl++;
            }
            if(tot + op - cl < 0) return false;
        }

        tot = op = cl = 0;
        for (int i = n-1; i >= 0; i--) {
            if(l.charAt(i) == '0'){
                tot++;
            }else if (s.charAt(i) == '(') {
                op++;
            }else if(s.charAt(i) == ')'){
                cl++;
            }
            if(tot - op + cl < 0) return false;
        }
        return true;
    }
}