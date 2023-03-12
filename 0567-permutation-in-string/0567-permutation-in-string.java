class Solution {
    public boolean checkInclusion(String s1, String s2) {
       return findAnagrams(s2, s1).size() > 0;
        //return helper(s1, s2);
    }
    
    public boolean helper(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1 > len2) return false;
        int freq[] = new int[26];
        
        for(int i = 0; i < len1; i++){
            freq[s1.charAt(i) - 'a']++; 
            freq[s2.charAt(i) - 'a']--;
        }
        
        if(allZero(freq)) return true;
        
        for(int i = len1; i < len2; i++){
            freq[s2.charAt(i) - 'a']--; 
            freq[s2.charAt(i - len1) - 'a']++;
            if(allZero(freq)) return true;
        }
        return false;
    }
    
    public boolean allZero(int[] freq){
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0) return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int plen = p.length();
        int slen = s.length();
        
        HashMap<Character, Integer> p_map = new HashMap<>();
        
        for(char ch : p.toCharArray()){
            p_map.put(ch, p_map.getOrDefault(ch, 0) + 1);
        }
        
        int counter = p_map.size();
        int begin = 0;
        List<Integer> result = new ArrayList<>();
        for (int end = 0; end < slen; end++) {
            char ch = s.charAt(end);
            if (p_map.containsKey(ch)) {
                p_map.put(ch, p_map.get(ch) - 1);
                if (p_map.get(ch) == 0) counter--;
            }
            while (counter == 0) {
                char tempch = s.charAt(begin);
                if (p_map.containsKey(tempch)) {
                    p_map.put(tempch, p_map.get(tempch) + 1);
                    if (p_map.get(tempch) > 0) counter++;
                }
                if (end - begin + 1 == plen)
                    result.add(begin);

                begin++;
            }
        }
        return result;
    }
}