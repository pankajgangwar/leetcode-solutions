class Solution {
    public boolean canBeValid(String s, String l) {
        int n = s.length();
        if(n%2==1) return false;
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if(l.charAt(i) == '0' || s.charAt(i) == '('){
                balance++;
            }else{
                balance--;
            }
            if(balance < 0) return false;
        }

        balance = 0;
        for (int i = n-1; i >= 0; i--) {
            if(l.charAt(i) == '0' || s.charAt(i) == ')'){
                balance++;
            }else{
                balance--;
            }
            if(balance < 0) return false;
        }
        return true;
    }
}