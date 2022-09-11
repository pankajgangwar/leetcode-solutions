class Solution {
    public int shortestWay(String source, String target) {
        ArrayList<Integer>[] list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < source.length(); i++) {
            list[source.charAt(i) - 'a'].add(i);
        }
        int res = 1, j = 0;
        for (int i = 0; i < target.length(); ) {
            int ch = target.charAt(i) - 'a';
            List<Integer> ids = list[ch];
            if(ids.isEmpty()){
                return -1;
            }
            int idx = Collections.binarySearch(ids, j);
            if(idx < 0) idx = ~idx;
            if(idx == ids.size()){
                res++;
                j = 0;
            }else{
                j = ids.get(idx) + 1;
                i++;
            }
        }
        return res;
    }
}