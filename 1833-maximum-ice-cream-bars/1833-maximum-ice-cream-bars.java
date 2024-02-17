class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total = 0;
        int n = costs.length;
        for(int i = 0; i < costs.length; i++){
            int c = costs[i];
            if(coins - c >= 0){
                coins -= c;
            }else{
                return (i);                
            }
        }
        return coins >= 0 ? n :  -1;
    }
}