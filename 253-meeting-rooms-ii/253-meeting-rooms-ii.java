class Solution {
    public int minMeetingRooms(int[][] intervals) {
         if(intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            int minEndTime = minHeap.peek();
            if(minEndTime <= intervals[i][0]){
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}