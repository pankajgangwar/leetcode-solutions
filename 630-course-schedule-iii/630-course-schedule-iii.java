class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int totalTime = 0;
        for (int i = 0; i < courses.length; i++) {
            totalTime += courses[i][0];
            pq.offer(courses[i][0]);
            if(totalTime > courses[i][1]){
                totalTime -= pq.poll();
            }
        }
        return pq.size();
    }
}