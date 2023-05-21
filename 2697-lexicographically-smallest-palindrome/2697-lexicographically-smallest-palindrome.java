class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        StringBuilder out = new StringBuilder(s);
        while (i <= j) {
            if (out.charAt(i) != out.charAt(j)) {
                int min = Math.min(s.charAt(i) - 'a', s.charAt(j) - 'a');
                char ch = (char) (min + 'a');
                out.setCharAt(i, ch);
                out.setCharAt(j, ch);
            }
            i++;
            j--;
        }
        return out.toString();
    }
}