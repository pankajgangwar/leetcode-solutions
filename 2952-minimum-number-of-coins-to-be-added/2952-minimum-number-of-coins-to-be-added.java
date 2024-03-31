class Solution {
    //https://leetcode.com/problems/patching-array/discuss/78488/Solution-%2B-explanation
    // LC : 330, Patching Array
    public int minimumAddedCoins(int[] coins, int target) {
        long miss = 1;
        int n = coins.length, i = 0, add = 0;
        Arrays.sort(coins);
        while(miss <= target){
            if(i < n && coins[i] <= miss){
                miss += coins[i++];
            }else{
                miss += miss;
                add++;
            }
        }
        return add;
    }
}