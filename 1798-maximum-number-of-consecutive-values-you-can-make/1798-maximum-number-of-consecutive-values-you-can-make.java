class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int n = coins.length;
        int ans = 1;
        Arrays.sort(coins);
        for(int a : coins){
            if(a > ans) return ans;
            ans += a;
        }
        return ans;
    }
}