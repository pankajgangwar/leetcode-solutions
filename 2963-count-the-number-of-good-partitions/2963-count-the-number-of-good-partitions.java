class Solution {
    public int numberOfGoodPartitions(int[] A) {
        int res = 1, n = A.length, mod = (int)1e9+7;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }
        for (int i = 0, j = 0; i < n; i++) {
            res = i > j ? (res * 2) % mod : res;
            j = Math.max(j, map.get(A[i]));
        }
        return res;
    }
}