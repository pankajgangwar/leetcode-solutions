class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, computeArea(bottomLeft[i][0], bottomLeft[i][1], topRight[i][0], topRight[i][1],
                        bottomLeft[j][0], bottomLeft[j][1], topRight[j][0], topRight[j][1]));
            }
        }
        return max;
    }

    public long computeArea(int a1, int a2, int b1, int b2, int x1, int x2, int y1, int y2) {
        boolean isIntersecting = a1 < y1 && x1 < b1 && a2 < y2 && x2 < b2;

        if(isIntersecting){
            int width = Math.min(y1, b1) - Math.max(a1, x1);
            int height = Math.min(b2, y2) - Math.max(x2, a2);
            int a = Math.min(width, height);
            return (long)a*a;
        }else{
            return 0;
        }
    }
}