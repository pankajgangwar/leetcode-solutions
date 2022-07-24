class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                return s.charAt(i);
            }
            map.put(s.charAt(i), i);
        }
        return 'a';
    }
}