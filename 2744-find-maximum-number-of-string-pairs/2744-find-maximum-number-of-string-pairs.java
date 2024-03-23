class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String w : words) {
            String rev = new StringBuilder(w).reverse().toString();
            if(map.containsKey(rev)){
                ans += map.getOrDefault(rev, 0);
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return ans;
    }
}