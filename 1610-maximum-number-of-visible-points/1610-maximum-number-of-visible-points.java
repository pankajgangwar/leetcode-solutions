class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int overlapWithSelf = 0;
        List<Double> angles = new ArrayList<>();
        for(List<Integer> point : points){
            if(location.get(0) == point.get(0) && location.get(1) == point.get(1)){
                overlapWithSelf++;
            }else {
                angles.add(getAngle(location, point));
                angles.add(getAngle(location, point) + 360);
            }
        }
        Collections.sort(angles);
        int res = 0;
        Queue<Double> q = new LinkedList<>();
        for(Double ang : angles){
            q.offer(ang);
            while (ang - q.peek() > angle){
                q.poll();
            }
            res = Math.max(res, q.size());
        }
        return res + overlapWithSelf;
    }
    private double getAngle(List<Integer> loc, List<Integer> point) {
        double angle = Math.toDegrees(Math.atan2(loc.get(1) - point.get(1), loc.get(0) - point.get(0)));
        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
}