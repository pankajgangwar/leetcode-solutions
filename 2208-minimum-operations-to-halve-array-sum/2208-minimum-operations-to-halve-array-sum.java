class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a));
        double sum = (double) Arrays.stream(nums).summaryStatistics().getSum();
        double req_sum = sum / 2;
        for(int a : nums){
            pq.offer((double)a);
        }
        int ans = 0;
        while (!pq.isEmpty()){
            double a = pq.poll();
            //System.out.println(a);
            sum -= a;
            a /= 2;
            sum += a;
            ans++;
            if(sum <= req_sum) return ans;
            pq.offer(a);
            
        }
        return ans;
    }
}