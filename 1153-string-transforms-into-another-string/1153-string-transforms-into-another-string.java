class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        if(str1.length() != str2.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> str2Set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            str2Set.add(ch2);
            if(!map.containsKey(ch1)){
                map.put(ch1, ch2);
            }else{
                if(map.get(ch1) != ch2){
                    return false;
                }
            }
        }
        if(map.size() == 26 && str2Set.size() == 26){ 
            // we are not left with any temp variable to swap in this case
            return false;
        }
        return true;
    }
}