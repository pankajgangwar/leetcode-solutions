class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[2 * n - 1];
        helper(0, ans, visited, n);
        return ans;
    }

    public boolean helper(int idx, int[] ans, boolean[] visited, int n){
        if(idx == ans.length) return true;
        if(ans[idx] != 0) return helper(idx + 1, ans, visited, n);
        for (int i = n; i >= 1 ; i--) {
            if(visited[i]) continue;
            visited[i] = true;
            ans[idx] = i;
            if(i == 1){
                if(helper(idx + 1, ans, visited, n)) return true;
            }else if(idx + i < ans.length && ans[idx + i] == 0){
                ans[i + idx] = i;
                if(helper(idx + 1, ans, visited, n)){
                    return true;
                }
                ans[i + idx] = 0;
            }
            ans[idx] = 0;
            visited[i] = false;
        }
        return false;
    }
}