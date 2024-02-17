class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<String, Integer> seen = new HashMap<>();
        int total = 0;
        for(List<Integer> c1 : coordinates){
            int x1 = c1.get(0), y1 = c1.get(1);
            //using a^b=c , then a^c=b
            //c[i][0]^x+c[i][1]^y=k                   (0)
            //Consider above is true , then
            //if , c[i][0]^x=val                      (1)
            //then c[i][1]^y=k-val                    (2)
            //we have c[i][0]^val=x;
            //we have c[i][1]^(k-val)=y;

            for (int val = 0; val <= k ; val++) {
                int x2 = (x1 ^ val);
                int y2 = y1 ^ (k - val);
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