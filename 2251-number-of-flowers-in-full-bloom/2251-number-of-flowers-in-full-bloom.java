class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[people.length];
        map.put(0, 0);
        for (int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int sum = 0;
        List<Integer> val = new ArrayList<>();
        for(int v : map.values()){
            sum += v;
            val.add(sum);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < people.length; i++) {
            int p = people[i];
            int idx = Collections.binarySearch(keys, p);
            if(idx < 0) idx = ~idx - 1;
            ans[i] = val.get(idx);
        }
        return ans;
    }
    
    public int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int p = people.length;
        int[] ans = new int[p];
        for (int[] flower : flowers) {
            pq.offer(new int[]{flower[0], 0});
            pq.offer(new int[]{flower[1], 2});
        }
        for (int i = 0; i < people.length; i++) {
            pq.offer(new int[]{people[i], 1, i});
        }
        int count = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(curr[1] == 0){
                count++;
            }else if(curr[1] == 1){
                ans[curr[2]] = count;
            }else{
                count--;
            }
        }
        return ans;
    }
}