class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> requestByServers = new HashMap<>();
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            int end  = load[i] + start;
            while (!heap.isEmpty() && heap.peek()[2] <= start){
                int[] req = heap.poll();
                int server = req[0];
                available.add(server);
            }
            if(!available.isEmpty()){
                Integer server = available.ceiling(i % k);
                if(server == null){
                    server = available.first();
                }
                available.remove(server);
                requestByServers.put(server, requestByServers.getOrDefault(server, 0) + 1);
                heap.offer(new int[]{server, start, end});
            }
        }
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>((a,b) -> b - a);
        for(Map.Entry<Integer, Integer> e : requestByServers.entrySet()){
            int req = e.getValue();
            int server = e.getKey();
            map.putIfAbsent(req, new LinkedList<>());
            map.get(req).add(server);
        }
        int maxReq = map.firstKey();
        res.addAll(map.get(maxReq));
        return res;
    }
}