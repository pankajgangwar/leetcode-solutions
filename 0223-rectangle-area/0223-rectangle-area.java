class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        boolean isIntersecting = A < G && E < C && B < H && F < D;

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if(isIntersecting){
            int width = Math.min(G, C) - Math.max(A, E);
            int height = Math.min(D, H) - Math.max(F, B);
            int intersection = width * height;
            int final_area = area1 + area2 - intersection;
            return final_area;
        }else{
            return area1 + area2;
        }
    }
}