class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] l  : lights) {
            int s = l[0] - l[1];
            int e = l[0] + l[1] + 1;
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) -1);
        }
        int sum = 0;
        int max = 0, res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            sum += e.getValue();
            if(max < sum){
                max = sum;
                res = e.getKey();
            }
        }
        return res;
    }
}