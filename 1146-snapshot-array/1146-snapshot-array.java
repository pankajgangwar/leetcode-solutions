class SnapshotArray {
    
    TreeMap<Integer, Integer>[] tmap;

        public SnapshotArray(int length) {
            tmap = new TreeMap[length];
            for(int i = 0; i < length; i++){
                tmap[i] = new TreeMap<Integer, Integer>();
                tmap[i].put(0,0);
            }
        }
        int snap_id = 0;
        public void set(int index, int val) {
            tmap[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int sId) {
            return tmap[index].floorEntry(sId).getValue();
        }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */