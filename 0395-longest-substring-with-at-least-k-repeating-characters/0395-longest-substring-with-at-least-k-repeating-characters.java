class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }
    
    public int helper(String s, int k){
        if(k < 1 || s.length() < k){
            return 0;
        }
        if(k == 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashSet<Character> sets = new HashSet<>();
        for (char ch : map.keySet()){
            if(map.get(ch) < k) {
                sets.add(ch);
            }
        }
        if(sets.isEmpty()) return s.length();
        int maxLen = 0;
        int i = 0, j = 0;
        while (j < s.length()){
            char ch = s.charAt(j);
            if(sets.contains(ch)){
                if(j != i){
                    maxLen = Math.max(maxLen, helper(s.substring(i, j), k));
                }
                i = j + 1;
            }
            j++;
        }
        if(i != j){
            maxLen = Math.max(maxLen, helper(s.substring(i, j), k));
        }
        return maxLen;
    }
}