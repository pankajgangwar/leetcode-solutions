class Solution {
    public boolean squareIsWhite(String loc) {
        int col = loc.charAt(0) - 'a';
        int row = loc.charAt(1) - '0' - 1;
        if(row%2==0){
            return col%2!=0;
        }
        return col%2==0;
    }
}