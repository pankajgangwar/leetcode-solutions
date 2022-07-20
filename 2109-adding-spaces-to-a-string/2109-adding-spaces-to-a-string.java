class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder out = new StringBuilder();
        for (int j = s.length() - 1, i = spaces.length - 1; j >= 0; j--) {
            out.append(s.charAt(j));
            if(i >= 0 && spaces[i] == j) {
                out.append(" ");
                i -= 1;
            }
        }
        return out.reverse().toString();
    }
}