class Pair {
        public int index;
        String s;
        int freq;
        public Pair(String s, int freq, int idx) {
            this.s = s;
            this.freq = freq;
            this.index = idx;
        }
    }

class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < responses.length; i++) {
            String res = responses[i];
            String[] arr = res.split(" ");
            HashSet<String> unique = new HashSet<>();
            for(String s : arr){
                unique.add(s);
            }
            for(String s : unique){
                freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
            }
        }
        HashSet<Integer> added = new HashSet<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < features.length; i++) {
            indexMap.put(features[i], i);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> a.freq == b.freq ? a.index - b.index : b.freq - a.freq);
        for(Map.Entry<String, Integer> e : freqMap.entrySet()){
            String feature = e.getKey();
            int index = indexMap.getOrDefault(feature, -1);
            if(index < 0) {
                continue;
            }
            added.add(index);
            maxHeap.offer(new Pair(feature, e.getValue(), index));
        }
        for (int i = 0; i < features.length; i++) {
            if(added.contains(i)) continue;
            maxHeap.offer(new Pair(features[i], 0, i));
        }
        List<String> res = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            res.add(maxHeap.poll().s);
        }
        return res.toArray(new String[res.size()]);
    }
}