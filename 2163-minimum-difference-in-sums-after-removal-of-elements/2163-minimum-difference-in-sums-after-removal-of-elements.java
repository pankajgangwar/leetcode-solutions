class Solution {
    public long minimumDifference(int[] nums) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b  - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length / 3;
        long s1 = 0, s2 = 0;
        long[] dp = new long[nums.length];
        for (int i = 0; i < 2*n; i++) {
            int curr = nums[i];
            maxHeap.offer(curr);
            s1 += curr;
            if(maxHeap.size() > n){
                s1 -= maxHeap.poll();
            }
            dp[i] = s1;
        }
        long minDiff = Long.MAX_VALUE;
        for (int i = nums.length - 1; i >= n; --i) {
            int curr = nums[i];
            minHeap.offer(curr);
            s2 += curr;
            if(minHeap.size() > n){
                s2 -= minHeap.poll();
            }
            if(minHeap.size() == n){
                minDiff = Math.min(minDiff, dp[i-1] - s2);
            }
        }
        return minDiff;
    }
}