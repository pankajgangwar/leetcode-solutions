class Solution {
    public long minimumCost(String s) {
        long res = 0;
        int n = s.length();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){
                res += Math.min(i, n - i);    
            }
        }
        return res;
    }
}