class Solution {
    public String firstPalindrome(String[] words) {
        for(String w : words){
            StringBuilder out = new StringBuilder(w);
            if(w.contentEquals(out.reverse())){
                return w;
            }
        }
        return "";
    }
}