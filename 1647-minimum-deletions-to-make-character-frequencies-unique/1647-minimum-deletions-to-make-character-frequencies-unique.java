class Solution {
    public int minDeletions(String s) {
        TreeMap<Integer, LinkedList<Character>> map = new TreeMap<>(Collections.reverseOrder());
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>((a,b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int fr = entry.getValue();
            char ch = entry.getKey();
            map.putIfAbsent(fr, new LinkedList<>());
            map.get(fr).add(ch);
        }
        for(Map.Entry<Integer, LinkedList<Character>> entry : map.entrySet()){
            pq.offer(new Entry(entry.getKey(), entry.getValue()));
        }
        int deletion = 0;
        while (!pq.isEmpty()){
            Entry highest = pq.poll();
            int currFreq = highest.freq;
            LinkedList<Character> chars = highest.charsList;
            if(chars.size() > 1){
                char removed = chars.pollFirst();
                if(!pq.isEmpty() && pq.peek().freq == currFreq - 1){
                    Entry second = pq.poll();
                    second.charsList.add(removed);
                    pq.offer(second);
                }else if(currFreq > 1){
                    LinkedList<Character> secList = new LinkedList<>();
                    secList.add(removed);
                    pq.offer(new Entry(currFreq - 1,  secList));
                }
                pq.offer(highest);
                deletion++;
            }
        }
        return deletion;
    }
    class Entry {
        int freq;
        LinkedList<Character> charsList;
        public Entry(int currF, LinkedList<Character> list){
            this.freq = currF;
            this.charsList = list;
        }
    }
}