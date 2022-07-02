class Solution {
    public boolean checkString(String s) {
        int i = s.indexOf("b");
        if(i < 0) return true;
        while (i < s.length() && s.charAt(i) == 'b') i++;
        return i == s.length();
    }
}