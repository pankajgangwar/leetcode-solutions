class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<Integer, List<String>> tmap = new TreeMap<>(Collections.reverseOrder());
        
        Map<String,Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            hMap.put(word, hMap.getOrDefault(word, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : hMap.entrySet()){
            tmap.putIfAbsent(entry.getValue(), new ArrayList<>());
            tmap.get(entry.getValue()).add(entry.getKey());
        }
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<Integer, List<String>> entry : tmap.entrySet()){
            List<String> list = entry.getValue();
            Collections.sort(list);
            for(String curr : list){
                if(k == 0) break;
                res.add(curr);
                k--;
            }
        }
        
        return res;
    }
    
}