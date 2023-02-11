class IdView{
        String id;
        int view;
        public IdView(String id, int view) {
            this.id = id;
            this.view = view;
        }
    }

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Long> creatorMap = new HashMap<>();
        HashMap<String, PriorityQueue<IdView>> videoMap = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            creatorMap.put(creators[i], creatorMap.getOrDefault(creators[i], 0L) + views[i]);
            videoMap.putIfAbsent(creators[i], new PriorityQueue<>((a,b) ->
                    a.view == b.view ? a.id.compareTo(b.id) : b.view - a.view));
            videoMap.get(creators[i]).offer(new IdView(ids[i], views[i]));
        }
        TreeMap<Long, List<String>> t = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String, Long> e : creatorMap.entrySet()){
            String creator = e.getKey();
            long totalViews = e.getValue();
            t.putIfAbsent(totalViews, new ArrayList<>());
            t.get(totalViews).add(creator);
        }
        long mostView = t.firstKey();
        List<List<String>> res = new ArrayList<>();
        for(String c : t.get(mostView)){
            List<String> s = new ArrayList<>();
            String id = videoMap.get(c).poll().id;
            s.add(c);
            s.add(id);
            res.add(s);
        }
        return res;
    }
}