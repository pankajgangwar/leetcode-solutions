class Solution {
    public int maximumLengthSubstring(String s) {
       int start = 0, end = 0;
        int res = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < n){
            char endCh = s.charAt(end);
            while(start < n && map.containsKey(endCh) && map.get(endCh) >= 2){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            map.put(endCh, map.getOrDefault(endCh, 0) + 1);
            res = Math.max(res, end - start + 1);
            end++;
        }
        System.out.println(res);
        return res;
    }
}