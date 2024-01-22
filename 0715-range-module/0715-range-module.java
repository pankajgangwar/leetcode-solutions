class RangeModule {

   TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        public RangeModule() {

        }

        public void addRange(int left, int right) {
            if(right <= left) return;
            Integer start = treeMap.floorKey(left);
            Integer end = treeMap.floorKey(right);
            if(start == null && end == null){
                treeMap.put(left, right);
            }else if(start != null && treeMap.get(start) >= left){
                treeMap.put(start, Math.max(treeMap.get(start), Math.max(treeMap.get(end), right)));
            }else {
                treeMap.put(left, Math.max(treeMap.get(end), right));
            }
            // Clear intermediate intervals
            Map<Integer, Integer> subMap = treeMap.subMap(left, false, right, false);
            Set<Integer> set = new HashSet<>(subMap.keySet());
            treeMap.keySet().removeAll(set);
        }

        public boolean queryRange(int left, int right) {
            Integer start = treeMap.floorKey(left);
            if(start == null) return false;
            return treeMap.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            if(right <= left) return;
            Integer start = treeMap.floorKey(left);
            Integer end = treeMap.floorKey(right);
            System.out.println("start " + start + " end = " + end);
            if(end != null && treeMap.get(end) > right){
                treeMap.put(right, treeMap.get(end));
            }
            if(start != null && treeMap.get(start) > left){
                treeMap.put(start, left);
            }
            Map<Integer, Integer> subMap = treeMap.subMap(left, false, right, false);
            Set<Integer> set = new HashSet<>(subMap.keySet());
            treeMap.keySet().removeAll(set);
        }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */