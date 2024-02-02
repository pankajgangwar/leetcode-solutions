class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        PriorityQueue<Integer> lPQ = new PriorityQueue<>((a,b) -> heights[a] == heights[b] ? b - a : heights[a] - heights[b]);
        PriorityQueue<Integer> rPQ = new PriorityQueue<>((a,b) -> heights[a] == heights[b] ? a - b : heights[a] - heights[b]);

        int l = k - 1;
        int r = k + 1;
        for (int v = 0; v < volume; v++) {
            while (l >=0 && heights[l] <= heights[l+1]) lPQ.offer(l--);
            while (r < heights.length && heights[r] <= heights[r-1]) rPQ.offer(r++);
            if(!lPQ.isEmpty() && heights[lPQ.peek()] < heights[k]){
                int idx = lPQ.poll();
                heights[idx] += 1;
                lPQ.offer(idx);
            }else if(!rPQ.isEmpty() && heights[rPQ.peek()] < heights[k]){
                int idx = rPQ.poll();
                heights[idx] += 1;
                rPQ.offer(idx);
            }else{
                heights[k]+=1;
            }
        }
        return heights;
    }
}