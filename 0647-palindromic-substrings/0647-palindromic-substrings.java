class Solution {
    /*
    Based on Manacher's Algorithm
    Similar with LC: 5 (Longest Palindromic substring)
    */
    public int countSubstrings(String s) {
        return countSubstringsManachers(s);
    }

    
    public int countSubstringsManachers(String s){
        if(s.length() == 0) return 0;

        int count = 0;

        for(int i = 0; i < s.length(); i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    public int countPalindrome(String s, int low, int high){
        int n = s.length();
        int count = 0;
        while(low >=0 && high < n && s.charAt(low) == s.charAt(high)){
            count++;
            low--;
            high++;
        }
        return count;
    }
    
    public int countSubstringsBruteForce(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                String sub = s.substring(i, j);
                if(isPalindrome(sub)){
                    count++;
                }
            }    
        }
        return count;
    }
    
    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() -1;
        while(low <= high){
            if(s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            --high;
        }
        return true;
    }
}