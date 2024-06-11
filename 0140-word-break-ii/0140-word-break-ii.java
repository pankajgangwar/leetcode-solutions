class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);

        //wordBreakRec(s, "", dict, 0);
        return wordBreakMemo(s, dict, new HashMap<String, List<String>>());
        //return wordBreakBFS(s, wordDict); // WA
        //return result;
    }

    public List<String> wordBreakMemo(String source,HashSet<String> dict, HashMap<String, List<String>> map) {
        int n = source.length();
        if(map.containsKey(source)){
            return map.get(source);
        }
        List<String> result = new ArrayList<>();

        if(n == 0){
            result.add("");
            return result;
        }

        for(String str : dict) {
            if(source.startsWith(str)){
                List<String> sub_list = wordBreakMemo(source.substring(str.length()), dict, map);
                for(String stored : sub_list){
                    result.add(str + (stored.isEmpty() ? "" : " " ) + stored);
                }
            }
        }
        map.put(source, result);
        return result;
    }
    
    public List<String> wordBreakBFS(String s, List<String> wordDict) {
        
        int n = s.length();
        
        HashSet<String> dict = new HashSet<>();
        
        for(String str : wordDict){
            dict.add(str);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<String>> map = new HashMap<>();
        
        while(!q.isEmpty()){
            
            int start = q.poll();

            if(!visited[start]){
                for(int end = start + 1; end <= n; end++){
                    if(dict.contains(s.substring(start, end))){
                        List<String> sentences = new ArrayList<>();
                        if(map.containsKey(start)){
                            sentences = map.get(start);
                        }
                        List<String> newList = new ArrayList<>();
                        if(sentences.isEmpty()){
                            String str = s.substring(start, end);
                            newList.add(str);
                        }else{
                            for(String str : sentences){
                                str += " " + s.substring(start, end);
                                newList.add(str);
                            }    
                        }
                        
                        List<String> endList = new ArrayList<>();
                        if(map.containsKey(end)){
                            endList = map.get(end);    
                        }
                        
                        map.remove(start);
                        
                        endList.addAll(newList);
                        map.put(end, endList);
                        
                        if(end == n){
                            break;
                        }
                        
                        q.offer(end);
                        
                    }
                    
                }
            }
            visited[start] = true;
        }
        
        List<String> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: map.entrySet()){
            List<String> list = entry.getValue();
            result.addAll(list);
        }
        return result;
    }
}