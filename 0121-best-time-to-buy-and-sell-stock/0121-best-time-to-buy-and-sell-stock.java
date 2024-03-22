class Solution {
    public int maxProfit(int[] prices) {
        return usingKadanesAlgo(prices);
    }
    
    public int usingDp(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int n = prices.length;
        int max_profit = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(max, prices[i]);
            if(prices[i] < min){
                min = prices[i];
                max = min;
            }
            max_profit = Math.max(max_profit, max - min);
        }
        return max_profit;
    }
    
    
    public int usingKadanesAlgo(int[] prices){
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i = 1; i < prices.length; i++){
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}