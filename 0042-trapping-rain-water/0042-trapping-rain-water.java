class Solution {
    public int trap(int[] height) {
        
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int n = height.length;
        
        if(n == 0){
            return 0;
        }

        lMax[0] = height[0];

        for(int i = 1; i < n; i++){
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        rMax[n-1] = height[n-1];

        for (int i = n-2; i >= 0 ; --i) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int max_water_trapped = 0;
        for(int i = 0; i < n; i++){
            int min_water = Math.min(rMax[i], lMax[i]);

            if(min_water > height[i]){
                max_water_trapped += min_water - height[i];
            }
        }
        return max_water_trapped;
    }
}