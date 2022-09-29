class Solution {
    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] p = peaks[i];
            intervals[i] = new int[]{p[0] - p[1], p[1] + p[0]};
        }
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int i = 0;
        int cnt = 0;
        while (i < n){
            cnt++;
            if(i + 1 == n){
                return cnt;
            }
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart == intervals[i + 1][0]){
                cnt--;
            }
            while (i + 1 < n && intervals[i + 1][1] <= currEnd){
                i += 1;
            }
            i += 1;
        }
        return cnt;
    }
}