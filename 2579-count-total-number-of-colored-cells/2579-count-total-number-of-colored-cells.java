class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        int fourMultiple = 0;
        for(int i = 2; i <= n; i++){
            fourMultiple += 4;
            ans += fourMultiple;
        }
        return ans;
    }
}