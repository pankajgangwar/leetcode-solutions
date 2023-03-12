class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> map = new HashMap<>();
        if(s.length() == 0) return 0;
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr_char = s.charAt(i);

            if(map.containsKey(curr_char)){
                 j = Math.max(map.get(curr_char) + 1, j); // "abba" j should not point to a again when i = 3
            }
            map.put(curr_char, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}