class Solution {
     public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int bottomLeftX, int bottomLeftY, 
                                 int topRightX, int topRightY) {
        // Check if the circle's center is inside the rectangle
        if (xCenter >= bottomLeftX && xCenter <= topRightX
                && yCenter >= bottomLeftY && yCenter <= topRightY) {
            return true;
        }
        // Check if any of the rectangle's corners are inside the circle
        int[] a = new int[]{bottomLeftX, bottomLeftY};
        int[] b = new int[]{bottomLeftX, topRightY};
        int[] c = new int[]{topRightX, topRightY};
        int[] d = new int[]{topRightX, bottomLeftY};
        if(distance(xCenter, yCenter, a[0], a[1]) <= radius ||
                distance(xCenter, yCenter, b[0], b[1]) <= radius ||
                distance(xCenter, yCenter, c[0], c[1]) <= radius ||
                distance(xCenter, yCenter, d[0], d[1]) <= radius){
            return true;
        }
        // Check if any of the rectangle's edges intersect the circle
        for (int x = a[0]; x <= d[0]; x++) {
            if(distance(xCenter, yCenter, x, a[1]) <= radius){
                return true;
            }
        }
         
         for (int x = a[0]; x <= d[0]; x++) {
            if(distance(xCenter, yCenter, x, b[1]) <= radius){
                return true;
            }
        }

        for (int y = a[1]; y <= b[1]; y++) {
            if(distance(xCenter, yCenter, a[0], y) <= radius){
                return true;
            }
        }
         
         for (int y = a[1]; y <= b[1]; y++) {
            if(distance(xCenter, yCenter, c[0], y) <= radius){
                return true;
            }
        }
        return false;
    }
    
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}