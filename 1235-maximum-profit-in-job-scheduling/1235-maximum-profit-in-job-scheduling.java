class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            int st = startTime[i];
            int et = endTime[i];
            int pr = profit[i];
            jobs[i] = new int[]{st, et, pr};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for(int i = 1; i < n; i++){
            int pr = jobs[i][2];
            int idx = search(jobs[i][0], jobs);
            if(idx != -1){
                pr += dp[idx];
            }
            dp[i] = Math.max(pr, dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int search(int time, int[][] jobs){
        int low = 0, high = jobs.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(jobs[mid][1] <= time){
                if(jobs[mid + 1][1] <= time){
                    low = mid + 1;
                }else {
                    return mid;
                }
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}