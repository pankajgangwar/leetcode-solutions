class Solution {
    public int rearrangeCharacters(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int res = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        while (true){
            boolean flag = false;
            for(Character key : tMap.keySet()){
                if(!map.containsKey(key)){
                    flag = true;
                    break;
                }
                int required = tMap.get(key);
                int available = map.get(key);
                if(available < required){
                    flag = true;
                    break;
                }
                map.put(key, available - required);
            }
            if(flag) break;
            res += 1;
        }
        return res;
    }
}