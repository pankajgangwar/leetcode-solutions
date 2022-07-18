class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }
        int max = 0;
        for(int key : map.keySet()){
            int reserved = map.get(key);
            int count = 0;
            if((reserved & 60) == 0) count += 1; // if 2,3,4,5 are available
            if((reserved & 960) == 0) count += 1; // if 6,7,8,9 are available
            if((reserved & 240) == 0 && count == 0) count = 1; // if 4,5,6,7 are available
            max += count;
        }
        return max + 2 * (n - map.size());
    }
}