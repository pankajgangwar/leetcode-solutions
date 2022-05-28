class Solution {
    public long maximumImportance(int n, int[][] roads) {
      int[] values = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for(Integer city : map.keySet()){
            int incomingRoads = map.get(city);
            pq.offer(new int[]{city, incomingRoads});
        }
        int temp = n;
        while (!pq.isEmpty()){
            int[] city = pq.poll();
            values[city[0]] = temp;
            temp--;
        }
        long res = 0;
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            res += values[a] + values[b];
        }
        return res;  
    }
}