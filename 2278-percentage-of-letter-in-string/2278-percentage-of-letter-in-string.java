class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == letter) ? 1 : 0;
        }
        int n = s.length();
        return (count * 100) / n;
    }
}