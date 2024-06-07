class Solution {
    
    public int rectangleArea(int[][] rectangles) {
        List<int[]> nonOverlaps = new ArrayList<>();
        for(int[] r : rectangles){
            addRectangle(nonOverlaps, r, 0);
        }
        int mod = (int)1e9 + 7;
        long ans = 0;
        for(int[] r : nonOverlaps){
            long a = (long) (r[2] - r[0]) * (r[3] - r[1]);
            ans = (ans + a) % mod;
        }
        return (int)ans;
    }

    private void addRectangle(List<int[]> nonOverlaps, int[] currRect, int index) {
        if(index >= nonOverlaps.size()){
            nonOverlaps.add(currRect);
            return;
        }
        int[] r = nonOverlaps.get(index);
        if(currRect[2] <= r[0] || currRect[0] >= r[2] || currRect[3] <= r[1] || currRect[1] >= r[3]){
            addRectangle(nonOverlaps, currRect, index + 1);
            return;
        }
        if(currRect[0] < r[0]){
            addRectangle(nonOverlaps, new int[]{currRect[0], currRect[1],
                                                r[0], currRect[3]}, index + 1);
        }
        if(currRect[2] > r[2]){
            addRectangle(nonOverlaps, new int[]{r[2], currRect[1], 
                                                currRect[2], currRect[3]}, index + 1);
        }
        if(currRect[1] < r[1]){
            addRectangle(nonOverlaps, new int[]{
                Math.max(r[0], currRect[0]), currRect[1], 
                Math.min(currRect[2], r[2]), r[1]}, index + 1);
        }
        if(currRect[3] > r[3]){
            addRectangle(nonOverlaps, new int[]{
                Math.max(currRect[0], r[0]), r[3],
                Math.min(currRect[2], r[2]), currRect[3]}, index + 1);
        }
    }

}