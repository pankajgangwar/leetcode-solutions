class Solution {
    public int[] getModifiedArray(int n, int[][] updates) {
        // return bruteForce(n, updates);
        return optimal(n, updates);
    }
    
    public int[] optimal(int n, int[][] updates) {
        int[] res = new int[n+1];
        for(int[] x : updates){
            res[x[0]] += x[2];
            res[x[1] + 1] -= x[2];
        }

        for(int i = 1; i < n + 1; i++){
            res[i] += res[i - 1];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = res[i];
        }
        return ans;
    }


    public int[] bruteForce(int n, int[][] updates) {
        int[] res = new int[n];
        for(int i = 0; i < updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];

            for(int j = start; j <= end; j++){
                res[j] += inc;
            }
        }
        return res;
    }
}