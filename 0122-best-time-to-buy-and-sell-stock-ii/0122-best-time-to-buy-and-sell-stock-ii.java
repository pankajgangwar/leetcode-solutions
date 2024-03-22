class Solution {
    public int maxProfit(int[] prices) {
        int []profit = new int[prices.length];
        int max_profit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            if(prices[i + 1] > prices[i]){
                max_profit += prices[i + 1] - prices[i];
            }
        }
        System.out.println(max_profit);
        return max_profit ;
    }
}