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

    public long computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        boolean isIntersecting = A < G && E < C && B < H && F < D;

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if(isIntersecting){
            int width = Math.min(G, C) - Math.max(A, E);
            int height = Math.min(D, H) - Math.max(F, B);
            //System.out.println("width " + width + " height " + height);
            int a = Math.min(width, height);
            return (long)a*a;
        }else{
            return 0;
        }
    }
}