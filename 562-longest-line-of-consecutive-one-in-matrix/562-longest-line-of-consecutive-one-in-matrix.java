class Solution {
    class FourDim {
        int h, v, d, ad;
    }

    public int longestLine(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
       FourDim dp[][] = new FourDim[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                FourDim dim = new FourDim();
                dim.ad = 0;
                dim.d = 0;
                dim.h = 0;
                dim.v = 0;
                dp[i][j] = dim;
            }
        }

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(matrix[i-1][j-1] == 0) continue;
                FourDim dim = new FourDim();
                //Horizontal
                dim.h = dp[i][j-1].h + 1;
                dim.v = dp[i-1][j].v + 1;
                dim.d = dp[i-1][j-1].d + 1;

                if(i - 1 >= 0 && j + 1 < dp[0].length){
                    dim.ad = dp[i-1][j+1].ad + 1;
                }
                
                dp[i][j] = dim;
                int max1 = Math.max(dim.h, dim.v);
                int max2 = Math.max(dim.d, dim.ad);
                int max3 = Math.max(max1, max2);

                max = Math.max(max3, max);
            }
        }
        return max;
    }
}