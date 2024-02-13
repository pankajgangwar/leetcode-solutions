class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchRegEx(s, p);
    }

    public boolean isMatchRegEx(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatchRegEx(s, p.substring(2))) {
                return true;
            }
            if (s.length() > 0 && ((p.charAt(0) == '.') || s.charAt(0) == p.charAt(0))) {
                return isMatchRegEx(s.substring(1), p);
            }
            return false;
        } else {
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatchRegEx(s.substring(1), p.substring(1));
            }
            return false;
        }
    }
}