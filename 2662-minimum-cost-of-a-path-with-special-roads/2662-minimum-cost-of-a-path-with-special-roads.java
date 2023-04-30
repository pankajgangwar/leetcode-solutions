class Solution {
    public int minimumCost(int[] start, int[] target, int[][] sr) {
        List<int[]> filter = new ArrayList<>();
        for(int i = 0; i < sr.length; i++){
            int a = sr[i][0], b = sr[i][1], c = sr[i][2], d = sr[i][3], cost = sr[i][4];
            if(cost < Math.abs(a-c) + Math.abs(b-d)){
                filter.add(new int[]{a,b,c,d,cost});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == target[0] && curr[1] == target[1]){
                return curr[2];
            }
            if(visited.containsKey(curr[0]) && visited.get(curr[0]).contains(curr[1])){
                continue;
            }
            visited.putIfAbsent(curr[0], new HashSet<>());
            visited.get(curr[0]).add(curr[1]);

            int c = curr[2];
            pq.offer(new int[]{target[0], target[1], getCost(curr, target) + c});
            for(int[] r : filter){
                if(visited.containsKey(r[2]) && visited.get(r[2]).contains(r[3])){
                    continue;
                }
                int cost = c + r[4] + getCost(curr, new int[]{r[0], r[1]});
                pq.offer(new int[]{r[2], r[3], cost});

            }
        }
        return -1;
    }

    public int getCost(int[] x, int[] y){
        return Math.abs(x[0]- y[0]) + Math.abs(x[1] - y[1]);
    }
}