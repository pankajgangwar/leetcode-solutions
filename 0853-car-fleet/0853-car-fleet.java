class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < speed.length; i++) {
            map.put(position[i], speed[i]);
        }
        int fleet = 0;
        double slowest = 0;
        for(int pos : map.keySet()){
            double time = (double) (target - pos) / map.get(pos);
            if(time <= slowest) {
                continue;
            }
            fleet++;
            slowest = time;
        }
        return fleet;
    }
}