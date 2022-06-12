class Solution {
    public int countVowelSubstrings(String word) {
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