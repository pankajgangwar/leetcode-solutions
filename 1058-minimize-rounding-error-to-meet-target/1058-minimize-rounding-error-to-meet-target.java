class Solution {
    public String minimizeError(String[] prices, int target) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        double res = 0.0;
        for (int i = 0; i < prices.length; i++) {
            double p = Double.valueOf(prices[i]);
            double low = Math.floor(p);
            double high = Math.ceil(p);
            if(low != high){
                pq.offer((high - p) - (p - low));
            }
            res += p - low;
            target -= low;
        }
        if(target < 0 || target > pq.size()){
            return "-1";
        }
        while (target-- > 0){
            res += pq.poll();
        }
        return String.format("%.3f", res);
    }
}