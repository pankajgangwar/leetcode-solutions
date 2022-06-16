class Solution {
    public String longestPalindrome(String s) {
        //return longestPalindromeBruteForce(s);
        return longestPalindromeAnother(s);
    }
    
    int lowest;
    int maxlength = 0;
    //Manacher's algorithm, expand around centers
    public String longestPalindromeAnother(String s){
        if(s.length() < 2){
            return s;
        }

        for(int i = 0; i < s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }

        return s.substring(lowest, lowest + maxlength);
    }

    public void extendPalindrome(String s, int low, int high){
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            --low;
            ++high;
        }

        if(maxlength < high - low - 1){
            lowest = low + 1;
            maxlength = high - low - 1;
        }
    }

}