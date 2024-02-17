class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<String, Integer> seen = new HashMap<>();
        int total = 0;
        for(List<Integer> c1 : coordinates){
            int x1 = c1.get(0);
            int y1 = c1.get(1);
            for (int xd = 0; xd <= k ; xd++) {
                int x2 = (x1 ^ xd);
                int y2 = (y1 ^ (k - xd));
                String key = x2 + "," + y2;
                if(seen.containsKey(key)){
                    total += seen.getOrDefault(key, 0);
                }
            }
            String key = x1 + "," + y1;
            seen.put(key, seen.getOrDefault(key, 0) + 1 );
        }
        return total;
    }
}