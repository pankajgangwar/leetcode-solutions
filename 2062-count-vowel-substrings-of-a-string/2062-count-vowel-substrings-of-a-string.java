class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);

        int vow = 0, k = 0;

        for (int end = 0, start = 0; end < word.length(); end++) {
            char ch = word.charAt(end);
            if(map.get(ch) != null){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.get(ch) == 1){
                    ++vow;
                }
                while (vow == 5){
                    char ss = word.charAt(k);
                    map.put(ss, map.getOrDefault(ss, 0) - 1);
                    if(map.get(ss) == 0){
                        --vow;
                    }
                    k++;
                }
                ans += (k - start);
            }else{
                HashMap<Character, Integer> finalMap = map;
                map.forEach((key, value) -> {
                    finalMap.put(key, 0);
                });
                map = finalMap;
                vow = 0;
                k = start = end + 1;
            }
        }
        return ans;
    }
    
    public int countVowelSubstrings1(String word) {
        int n = word.length();
        String vowels = "aeiou";
        int res = 0;
        for (int i = 0; i < n - 4; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                if(vowels.indexOf(ch) >= 0){
                    seen.add(ch);
                    if(seen.size() == 5){
                        res++;
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }
}