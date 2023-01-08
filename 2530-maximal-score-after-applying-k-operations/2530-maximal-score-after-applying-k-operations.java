class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> -Long.compare(a,b));
        for (int i = 0; i < nums.length; i++) {
            pq.offer((long) nums[i]);
        }
        long ans = 0;
        while (k > 0 && pq.size() > 0){
            long max = pq.poll();
            ans += max;
            long rem = 0;
            if(max % 3 == 0){
                rem = max / 3;
            }else{
                rem = (max / 3) + 1;
            }
            pq.offer(rem);
            k -= 1;
        }
        return ans;
    }
}