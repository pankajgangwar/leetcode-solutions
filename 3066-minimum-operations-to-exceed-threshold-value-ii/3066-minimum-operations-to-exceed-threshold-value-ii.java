class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int a : nums){
            pq.offer((long)a);
        }
        int ans = 0;
        while (pq.size() >= 2){
            long a = pq.poll();
            long b = pq.poll();
            if(a >= k) return ans;
            pq.offer(Math.min(a, b) * 2 + Math.max(a, b));
            ans++;
        }
        return ans;
    }
}