class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        
        int n = intervals.length;
        
        if(n == 1 || n == 0) return 0;
        
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        res.add(prev);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] <= curr[0]){
                res.add(curr);
                prev = curr;
            }
        }
        return n - res.size();
    }
}