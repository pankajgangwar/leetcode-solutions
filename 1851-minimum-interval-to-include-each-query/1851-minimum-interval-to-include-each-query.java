class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
       TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; i < sortedQueries.length; i++) {
            while (j < intervals.length && intervals[j][0] <= sortedQueries[i]){
                map.put(intervals[j][1] - intervals[j][0] + 1, intervals[j][1]);
                j++;
            }
            while (!map.isEmpty() && map.firstEntry().getValue() < sortedQueries[i]){
                map.pollFirstEntry();
            }
            hashMap.put(sortedQueries[i], map.isEmpty() ? -1 : map.firstKey());
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = hashMap.get(queries[i]);
        }
        return ans;
    }
}