class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

        for (List<String> list : tickets) {
            String src = list.get(0);
            String dst = list.get(1);

            PriorityQueue<String> pq = new PriorityQueue<>();

            if (map.containsKey(src)) {
                pq = map.get(src);
            }

            pq.offer(dst);

            map.put(src, pq);
        }

        helperItinerary(map, "JFK");

        return route;
    }

    LinkedList<String> route = new LinkedList<>();

    public void helperItinerary(HashMap<String, PriorityQueue<String>> map, String src) {
        while (map.containsKey(src) && !map.get(src).isEmpty()) {
            String connected = map.get(src).poll();
            helperItinerary(map, connected);
        }

        route.addFirst(src);
    }
}
