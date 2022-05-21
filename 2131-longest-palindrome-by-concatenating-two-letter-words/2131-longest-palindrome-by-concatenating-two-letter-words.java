class Solution {
    
    public int longestPalindrome1(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> keys = new HashSet<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
            keys.add(s);
        }
        String pal = "";
        for(String s : keys){
            int freq = map.get(s);
            String rev = new StringBuilder(s).reverse().toString();
            if(map.containsKey(rev) && s.charAt(0) != s.charAt(1)){
                int revFreq = map.get(rev);
                int req = Math.min(revFreq, freq);
                if(req % 2 != 0){
                    req = Math.max(1, req - 1);
                }
                String second = new String(new char[req]).replace("\0", rev);
                String first = new String(new char[req]).replace("\0", s);
                pal = first + pal + second;
                map.put(s, freq - req);
                map.put(rev, revFreq - req);
            }else if(s.charAt(0) == s.charAt(1) && freq > 1){
                int req = freq / 2;
                
                String ss = new String(new char[req ]).replace("\0", s);
                pal = ss + pal + ss;
                map.put(s, freq % 2);
            }
        }

        for(Map.Entry<String, Integer> e : map.entrySet()){
            String s = e.getKey();
            int freq = e.getValue();
            if (freq == 1 && s.charAt(0) == s.charAt(1)){
                int mid = pal.length() / 2;
                CharSequence first = pal.substring(0, mid);
                CharSequence second = pal.substring(mid);
                pal = first + s + second;
                break;
            }
        }
        return pal.length();
    }
    
    public int longestPalindrome(String[] words) {
       HashMap<String, Integer> map = new HashMap<>();
        int unpaired = 0;
        int ans =0;
        for(String s : words){
            if(s.charAt(0) == s.charAt(1)){
                if(map.containsKey(s) && map.get(s) > 0){
                    ans += 4;
                    map.put(s, map.get(s) - 1);
                    unpaired--;
                }else{
                    unpaired++;
                    map.put(s, 1);
                }
            }else{
                String rev = s.charAt(1) + "" + s.charAt(0);
                if(map.containsKey(rev) && map.get(rev) > 0){
                    ans += 4;
                    map.put(rev, map.get(rev) - 1);
                }else{
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
        }
        if(unpaired > 0) ans += 2;
        return ans;
    }
}