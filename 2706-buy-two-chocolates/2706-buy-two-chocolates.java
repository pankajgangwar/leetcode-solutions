class Solution {
    public int buyChoco(int[] prices, int money) {
        HashMap<Integer, Integer> keys = new HashMap<>();
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(min1 > prices[i]){
                min2 = min1;
                min1 = prices[i];
            }else if(min2 > prices[i]){
                min2 = prices[i];
            }
        }
        //System.out.println(" min1: " + min1 + " min2: " + min2);
        int sum = min1 + min2;
        return money - sum >= 0 ? money - sum : money;
    }
}