class Solution {
    public long minimumSteps(String s) {
        long res = 0L;
        int n = s.length();
        long count = 0L;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0') count += 1;
            else res += count;
        }
        return res;
    }
}