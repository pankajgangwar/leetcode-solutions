class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }
        int max = 0;
        for (int row : map.keySet()) {
            Set<Integer> reserved = map.get(row);
            int count = 0;
            if (!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
                count += 1;
            }
            if (!reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
                count += 1;
            }
            if (!reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)) {
                if (count == 0) {
                    count += 1;
                }
            }
            max += count;
        }
        return max + 2 * (n - map.size());
    }

    public int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }
        int max = 0;
        for (int key : map.keySet()) {
            int reserved = map.get(key);
            int count = 0;
            if ((reserved & 60) == 0) count += 1; // if 2,3,4,5 are available
            if ((reserved & 960) == 0) count += 1; // if 6,7,8,9 are available
            if ((reserved & 240) == 0 && count == 0) count = 1; // if 4,5,6,7 are available
            max += count;
        }
        return max + 2 * (n - map.size());
    }
}
