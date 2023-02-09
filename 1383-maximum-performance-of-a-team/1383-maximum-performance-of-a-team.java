class Solution {
    //https://leetcode.com/problems/maximum-subsequence-score/
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long maxPerf = 0;
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(res, (a,b) -> -a[0] + b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        long sumSpeed = 0;
        for (int i = 0; i < n ; i++) {
            minHeap.offer(res[i]);
            sumSpeed += res[i][1];
            if(minHeap.size() > k){
                sumSpeed -= minHeap.poll()[1];
            }
            maxPerf = Math.max(maxPerf, res[i][0] * sumSpeed);
        }

        return (int) (maxPerf % (long)(1e9 + 7));
        
    }
}