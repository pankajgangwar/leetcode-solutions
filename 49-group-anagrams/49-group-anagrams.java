class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
       // return groupAnagramsWithSorting(strs);
         return groupAnagramsWithCount(strs);
    }

    public List<List<String>> groupAnagramsWithCount(String[] strs){
       Map<String, List<String>> map = new HashMap<>(); 
       int[] count = new int[26];
       for(String str : strs){
            Arrays.fill(count, 0);

            char[] arr = str.toCharArray();
            for(char ch : arr){
                count[ch - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < 26; i++){
                builder.append(count[i]);
                builder.append("#");
            }

            String hashKey = builder.toString();

            if(!map.containsKey(hashKey)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hashKey, list);
            }else{
                map.get(hashKey).add(str);
            }
       }
       return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagramsWithSorting(String[] strs) {
       Map<String, List<String>> map = new HashMap<>(); 
       
       for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String hashKey = new String(arr);

            if(!map.containsKey(hashKey)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hashKey, list);
            }else{
                map.get(hashKey).add(str);
            }
       }
       return new ArrayList<List<String>>(map.values());
    }
}