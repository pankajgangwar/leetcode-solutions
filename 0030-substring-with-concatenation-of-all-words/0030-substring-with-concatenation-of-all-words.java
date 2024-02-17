class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        
        List<Integer> result = new LinkedList<>();

        if(S == null || S.length() == 0 || L == null || L.length == 0 || S.length() < L.length * L[0].length())
            return result;

        int M = L.length;

        int N = S.length();

        int wl = L[0].length();

        Map<String, Integer> map = new HashMap<>(), currMap = new HashMap<>();

        for(String word : L ) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int counter = 0, begin = 0, end = 0;

        int len = Integer.MAX_VALUE;

        for(int i = 0; i < wl; i++){
            counter = 0;
            begin = i;

            for(int r = i; r+wl <= N; r += wl){

                String curr = S.substring(r, r + wl);
                
                if(map.containsKey(curr)){
                    currMap.put(curr, currMap.getOrDefault(curr, 0) + 1);
                    if(currMap.get(curr) <= map.get(curr)) counter++;

                    while(currMap.get(curr) > map.get(curr)){
                        String tmp = S.substring(begin, begin + wl);
                        currMap.put(tmp, currMap.get(tmp) - 1);
                        begin += wl;

                        if(currMap.get(tmp) < map.get(tmp)) counter--;
                    }

                    if(counter == M){
                        result.add(begin);
                        String tmp = S.substring(begin, begin + wl);
                        currMap.put(tmp, currMap.get(tmp) - 1);
                        begin += wl;
                        counter--;
                    }

                }else{
                    currMap.clear();
                    counter = 0;
                    begin = r + wl;
                }
            }
            currMap.clear();
        }
        return result;
    }
}