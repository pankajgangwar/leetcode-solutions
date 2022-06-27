class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> inProgress = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int max = 0;
        int maxOfCompletedEvents = 0;
        for(int[]event : events){
            while (!inProgress.isEmpty() && inProgress.peek()[1] < event[0]){
                maxOfCompletedEvents = Math.max(maxOfCompletedEvents, inProgress.poll()[2]);
            }
            max = Math.max(max, maxOfCompletedEvents + event[2]);
            inProgress.offer(event);
        }
        return max;
    }
}