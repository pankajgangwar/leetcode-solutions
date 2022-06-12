class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int start = 0;
        int end = 0;
        int n = word.length();
        while (end < n) {
            while (start < n && word.charAt(start) != 'a') start++;
            end = start;
            while (end < n && word.charAt(end) == 'a') end++;
            if (end == n) break;
            if (word.charAt(end) != 'e') {
                start = end;
                continue;
            }
            while (end < n && word.charAt(end) == 'e') end++;
            if (end == n) break;
            if (word.charAt(end) != 'i') {
                start = end;
                continue;
            }
            while (end < n && word.charAt(end) == 'i') end++;
            if (end == n) break;
            if (word.charAt(end) != 'o') {
                start = end;
                continue;
            }
            while (end < n && word.charAt(end) == 'o') end++;
            if (end == n) break;
            if (word.charAt(end) != 'u') {
                start = end;
                continue;
            }
            while (end < n && word.charAt(end) == 'u') end++;
            max = Math.max(max, end - start);
            start = end;
        }
        return max;
    }
}