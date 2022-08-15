class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long e = edges[i];
            map.put(e, map.getOrDefault(e, 0L) + i);
        }
        long res = -1, edge = -1;
        for(Map.Entry<Long, Long> e : map.entrySet()){
            if(res < e.getValue()){
                res = e.getValue();
                edge = e.getKey();
            }
        }
        return (int)edge;
    }
}