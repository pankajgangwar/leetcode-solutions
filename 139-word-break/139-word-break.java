class Solution {
    
    public boolean wordBreak(String string, List<String> wordDict) {
          return wordBreakBFS(string, wordDict);
        //return wordBreakDP(string, wordDict);
    }
    public boolean wordBreakDP(String string, List<String> wordDict) {
        int n = string.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0 ; --j) {
                if(dp[j] && wordDict.contains(string.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[string.length()];
    }
    
    public boolean wordBreakBFS(String string, List<String> wordDict) {
        int n = string.length();
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()){
            int start = q.poll();
            if(!visited[start]){
                for(int end = start + 1; end <= n; end++){
                    if(dict.contains(string.substring(start, end))){
                        q.offer(end);
                        if(end == n){
                            return true;
                        }
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }
    
}