/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int len = 0;
        int idx = 0;
        
        for(int i = 0; i < schedule.size(); i++ ){
            List<Interval> list = schedule.get(i);
            len += list.size();
        }
        
        int[][]intervals = new int[len][2];
        
        for(int i = 0; i < schedule.size(); i++ ){
            List<Interval> list = schedule.get(i);
            for(Interval val : list){
                int[] curr = new int[2];
                curr[0] = val.start;
                curr[1] = val.end;
                intervals[idx++] = curr;
            }
        }
        
        Arrays.sort(intervals, (a,b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        
        int[] curr = intervals[0];
        int max = curr[1];
        List<Interval> res = new ArrayList<>();
        for(int[] next : intervals){
            if(curr[1] >= next[0]){
                max = Math.max(curr[1], next[1]);
                curr[1] = max;
            }else{
                int start = curr[1];
                int end = next[0];
                Interval inter = new Interval(start, end);
                res.add(inter);
                curr = next;
            }
        }
        return res;
    }
}