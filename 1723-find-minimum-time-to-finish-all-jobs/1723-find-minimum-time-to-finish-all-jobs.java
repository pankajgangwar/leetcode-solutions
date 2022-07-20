class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        Arrays.sort(jobs);
        int low = jobs[0];
        int n = jobs.length;
        int high = (int)1e9;
        while (low < high){
            int mid = low + (high - low) / 2;
            Arrays.fill(workers, mid);
            if(dfs(jobs, workers, jobs.length - 1, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    public boolean dfs(int[] jobs, int[] workers, int j, int x){
        if(j == -1) return true;
        for (int i = 0; i < workers.length; i++) {
            if(workers[i] >= jobs[j]){
                workers[i] -= jobs[j];
                if(dfs(jobs, workers, j - 1, x)){
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