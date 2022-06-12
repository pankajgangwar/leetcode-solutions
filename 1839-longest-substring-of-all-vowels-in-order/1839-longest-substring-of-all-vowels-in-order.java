class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int n = word.length();
        HashSet<Character> seen = new HashSet<>();
        for (int end = 0, start = 0; end < n; end++) {
            if(end > 0 && word.charAt(end - 1) > word.charAt(end)){
                seen = new HashSet<>();
                start = end;
            }
            seen.add(word.charAt(end));
            if(seen.size() == 5){
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}