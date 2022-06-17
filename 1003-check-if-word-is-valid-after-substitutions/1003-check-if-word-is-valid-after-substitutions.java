class Solution {
    public boolean isValid(String S) {
        String t = "abc";
        
        if(S.equals(t)|| S.length() == 0) return true;
        
        int idx = S.indexOf(t);
        if(idx < 0){
            return false;
        }
        StringBuilder builder = new StringBuilder(S);
        builder.delete(idx, idx + t.length());
        
        return isValid(builder.toString());
        
    }
}