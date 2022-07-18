class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> result = new ArrayList<>();

        for(String word : words){
            if(word.length() > 0 && helper(word, dict)){
                result.add(word);
            }
            dict.add(word);
        }
        return result;
    }
    
     public boolean helper(String word,Set<String> dict){
        if(dict.isEmpty()) return false;
        int n = word.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i; j >= 0 ; --j){ // Instead of  for(int j = 0; j < i ; j++)
                if(dp[j] && dict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    
    public boolean wordBreakBFS(String string, Set<String> dict) {
        int n = string.length();
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