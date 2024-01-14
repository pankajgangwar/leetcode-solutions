class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            if(!map.containsKey(points[0])){
                map.putIfAbsent(points[i][0], new HashSet<Integer>());
            }
            map.get(points[i][0]).add(points[i][1]);
        }

        int min = Integer.MAX_VALUE;
        for(int[] p1 : points) {
            for(int[] p2 : points){
                if(p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1]) ){
                    //System.out.println(Arrays.toString(p1) + " , " + Arrays.toString(p2) );
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) *  Math.abs(p1[1] - p2[1]) );
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
            
}