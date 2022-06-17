class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i % 3 != n % 3){
                res += cost[i];
            }
        }
        return res;
    }
}