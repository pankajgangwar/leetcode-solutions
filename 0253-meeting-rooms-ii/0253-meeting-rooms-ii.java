class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        //If two intervals overlaps.. different meeting rooms required
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        min_heap.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            
            int min_end_time = min_heap.peek();

            if(min_end_time <= intervals[i][0]){
                min_heap.poll();   
            }

            min_heap.offer(intervals[i][1]);
        }

        return min_heap.size();
        
    }
}