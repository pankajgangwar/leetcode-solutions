class Solution {
    public int equalCountSubstrings(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) set.add(ch);
        int res = 0, max_unique = set.size();
        for(int unique = 1; unique <= max_unique; ++unique){
            int[]cnt = new int[26];
            int len = k * unique, has_count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(++cnt[s.charAt(i) - 'a'] == k){
                    ++has_count;
                }
                if(i >= len && --cnt[s.charAt(i - len) - 'a'] == k - 1){
                    --has_count;
                }
                res += (has_count == unique) ? 1 : 0;
            }
        }
        return res;
    }

}