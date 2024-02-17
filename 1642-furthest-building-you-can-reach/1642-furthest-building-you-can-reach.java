class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if(d <= 0) continue;
            pq.offer(d);
            bricks -= d;
            if(bricks < 0){ // if no more bricks left, use ladder and restore max bricks
                bricks += pq.poll();
                if(ladders > 0) ladders--;
                else return i;
            }
        }
        return n - 1;
    }
}