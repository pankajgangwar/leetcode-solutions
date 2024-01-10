class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        
        List<int[]> res = new  ArrayList<>();
        int[] prev = points[0];
        res.add(prev);
        
        for(int[] point : points){
            if(prev[1] < point[0]) {
                res.add(point);
                prev = point;
            }
        }
        return res.size();
    }
}