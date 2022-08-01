class Solution {
    public int connectSticks(int[] sticks) {
         PriorityQueue<Integer> mMinHeap = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            mMinHeap.offer(sticks[i]);
        }

        int total_cost = 0;
        while (mMinHeap.size() > 1){
            int stick1 = mMinHeap.poll();
            int stick2 = mMinHeap.poll();
            
            int combine = stick1 + stick2;
            total_cost += (combine);
            
            mMinHeap.offer(combine);
        }
        
        return total_cost;
    }
}