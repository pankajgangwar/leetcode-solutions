class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(String s : words1){
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for(String s : words2){
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> e : map1.entrySet()){
            if(e.getValue() == 1 && map2.getOrDefault(e.getKey(), 0) == 1) {
                count++;
            }
        }
        return count;
    }
}