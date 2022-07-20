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
    
    public int minimumTimeRequiredBinarySearch(int[] jobs, int k) {
        int[] workers = new int[k];
        Arrays.sort(jobs);
        int low = jobs[0];
        int n = jobs.length;
        int high = (int)1e9;
        while (low < high){
            int mid = low + (high - low) / 2;
            Arrays.fill(workers, mid);
            if(search(jobs, workers, jobs.length - 1, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    public boolean search(int[] jobs, int[] workers, int j, int x){
        if(j == -1) return true;
        for (int i = 0; i < workers.length; i++) {
            if(workers[i] >= jobs[j]){
                workers[i] -= jobs[j];
                if(search(jobs, workers, j - 1, x)){
                    return true;
                }
                workers[i] += jobs[j];
            }
            if(workers[i] == x){
                break;
            }
        }
        return false;
    }

}