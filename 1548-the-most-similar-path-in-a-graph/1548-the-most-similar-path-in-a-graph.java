class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        int m = targetPath.length;
        int[][] dp = new int[m][n];
        int[][] parent = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = names[i].equals(targetPath[0]) ? 0 : 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k : graph[j]){
                    if(dp[i][j] > dp[i - 1][k] + (names[j].equals(targetPath[i]) ? 0 : 1)){
                        dp[i][j] = dp[i - 1][k] + (names[j].equals(targetPath[i]) ? 0 : 1);
                        parent[i][j] = k;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 0; i < n; i++){
            if(min > dp[m - 1][i]){
                min = dp[m - 1][i];
                minIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(minIdx);
        for(int i = m - 1; i > 0; i--){
            ans.add(parent[i][minIdx]);
            minIdx = parent[i][minIdx];
        }
        Collections.reverse(ans);
        return ans;
    }
}