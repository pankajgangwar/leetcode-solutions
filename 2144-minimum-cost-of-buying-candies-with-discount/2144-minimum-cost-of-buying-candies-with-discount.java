class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        if(n == 2) return cost[0] + cost[1];
        if(n == 1) return cost[0];
        int ans = 0;
        for (int i = n-1; i >= 0;) {
           if(i-2 < 0){
               if(i == 1) ans += cost[0] + cost[1];
               else if(i == 0) ans += cost[0];
           }else{
               ans += (cost[i] + cost[i-1]);
           }
           i -= 3;
        }
        return ans;
    }
}