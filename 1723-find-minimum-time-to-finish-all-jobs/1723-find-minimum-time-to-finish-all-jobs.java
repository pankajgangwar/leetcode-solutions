class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        dfs(jobs, workers, jobs.length - 1, 0);
        return res;
    }
    int res = Integer.MAX_VALUE;
    public void dfs(int[] jobs, int[] workers, int j, int max){
        if(j == -1){
            res = Math.min(res, max);
            return;
        }
        if(res < max) {
            return;
        }
        for (int i = 0; i < workers.length; i++) {
            workers[i] += jobs[j];
            dfs(jobs, workers, j - 1, Math.max(workers[i], max));
            workers[i] -= jobs[j];
            if(workers[i] == 0) break;
        }
    }

}