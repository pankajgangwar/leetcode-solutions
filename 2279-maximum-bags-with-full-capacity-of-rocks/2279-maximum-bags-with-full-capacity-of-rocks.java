class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < capacity.length; i++) {
            long req = capacity[i] - rocks[i];
            if(req == 0) {
                ans += 1;
                continue;
            }
            minHeap.offer(req);
        }
        while (!minHeap.isEmpty() && additionalRocks > 0){
            long req = minHeap.poll();
            if(additionalRocks >= req){
                additionalRocks -= req;
                ans++;
            }
        }
        return ans;
    }
}