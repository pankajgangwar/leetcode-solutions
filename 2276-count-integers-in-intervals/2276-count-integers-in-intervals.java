class CountIntervals {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        public CountIntervals() {

        }

        public void add(int left, int right) {
           if(map.floorKey(right) == null || map.get(map.floorKey(right)) < left){
                count += (right - left + 1);
                map.put(left, right);
            }else{
                int start = left;
                int end = right;
                while (map.floorKey(end) != null && map.get(map.floorKey(end)) >= start){
                    int l = map.floorKey(end);
                    int r = map.get(l);
                    start = Math.min(start, l);
                    end = Math.max(end, r);
                    count -= (r - l + 1);
                    map.remove(l);
                }
                count += (end - start + 1);
                map.put(start, end);
            }
        }

        public int count() {
            return count;
        }
    }

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */