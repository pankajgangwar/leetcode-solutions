class Solution {
    
    public int longestStrChain(String[] words) {
        int len = words.length;
        if(len <= 1) return len;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        int[] dp = new int[words.length + 1];
        Arrays.fill(dp, 1);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String prev = words[i].substring(0, j) + words[i].substring(j+1);
                if(map.containsKey(prev)){
                    int prevIdx = map.get(prev);
                    if(prevIdx < i){
                        dp[i] = Math.max(dp[i], dp[prevIdx] + 1);
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
    public int longestStrChainMap(String[] words) {
        int len = words.length;
        if(len <= 1) return len;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int best = 0;
            for (int j = 0; j < words[i].length(); j++) {
                String prev = words[i].substring(0, j) + words[i].substring(j+1);
                best = Math.max(best, map.getOrDefault(prev, 0) + 1);
            }
            map.put(words[i], best);
            res = Math.max(res, best);
        }
        return res;
    }
}