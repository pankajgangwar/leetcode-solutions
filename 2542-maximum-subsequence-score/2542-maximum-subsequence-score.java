class Solution {
    //https://leetcode.com/problems/maximum-performance-of-a-team/
    public long maxScore(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        int[][] res = new int[n][2];
        for (int i = 0; i < speed.length; i++) {
            res[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(res, (a,b) -> -a[0] + b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < res.length; i++) {
            minHeap.offer(res[i]);
            sum += res[i][1];
            if(minHeap.size() > k){
                sum -= minHeap.poll()[1];
            }
            if(minHeap.size() == k){
                ans = Math.max(ans, sum * res[i][0]);
            }
        }
        return ans;
    }
}