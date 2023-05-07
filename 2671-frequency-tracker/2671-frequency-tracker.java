class FrequencyTracker {

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, HashSet<Integer>> tMap = new TreeMap<>();
        public FrequencyTracker() {

        }

        public void add(int number) {
            int occ = map.getOrDefault(number, 0);
            int newOcc = occ + 1;
            map.put(number, newOcc);
            tMap.putIfAbsent(newOcc, new HashSet<>());
            tMap.get(newOcc).add(number);
            if(tMap.containsKey(occ) &&
                    tMap.getOrDefault(occ, new HashSet<>()).contains(number)){
                tMap.get(occ).remove(number);
            }
        }

        public void deleteOne(int number) {
            if(!map.containsKey(number)) return;
            int occ = map.getOrDefault(number, 0);
            tMap.getOrDefault(occ, new HashSet<>()).remove(number);
            if(--occ >= 0){
                map.put(number, occ);
                tMap.putIfAbsent(occ, new HashSet<>());
                tMap.get(occ).add(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return tMap.containsKey(frequency) && !tMap.get(frequency).isEmpty();
        }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */