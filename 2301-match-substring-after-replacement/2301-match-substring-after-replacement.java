class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < mappings.length; i++) {
            char[] ch = mappings[i];
            map.putIfAbsent(ch[0], new HashSet<>());
            map.get(ch[0]).add(ch[1]);
        }

        int start = 0;
        while (start < s.length()){
            int i = start;
            int j = 0;
            while (i < s.length() && j < sub.length()){
                char ch1 = s.charAt(i);
                char ch2 = sub.charAt(j);
                if(ch1 != ch2 && !map.containsKey(ch2)) break;
                if(ch1 == ch2 || map.get(ch2).contains(ch1)){
                    i++;j++;
                }else{
                    break;
                }
            }
            if(j == sub.length()){
                return true;
            }
            start++;
        }
        return false;
    }
}

