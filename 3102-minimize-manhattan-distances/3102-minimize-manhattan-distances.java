class Solution {
    
    public int minimumDistance(int[][] points) {
        int n = points.length;
        int[] m = solve(points, -1);
        return Math.min(solve(points, m[1])[0], solve(points, m[2])[0]);
    }

    int[] solve(int[][] p, int skip){
        int n = p.length;

        int[] sum = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] sum_i = new int[]{0, 0};

        int[] diff = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] diff_i = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            if(skip == i) continue;
            if(sum[0] > p[i][0] + p[i][1]){
                sum[0] = p[i][0] + p[i][1];
                sum_i[0] = i;
            }
            if(sum[1] < p[i][0] + p[i][1]){
                sum[1] = p[i][0] + p[i][1];
                sum_i[1] = i;
            }
            if(diff[0] > p[i][0] - p[i][1]){
                diff[0] = p[i][0] - p[i][1];
                diff_i[0] = i;
            }
            if(diff[1] < p[i][0] - p[i][1]){
                diff[1] = p[i][0] - p[i][1];
                diff_i[1] = i;
            }
        }
        if(sum[1] - sum[0] > diff[1] - diff[0]){
            return new int[]{sum[1] - sum[0],sum_i[0], sum_i[1]};
        }else{
            return new int[]{diff[1] - diff[0],diff_i[0], diff_i[1]};
        }
    }
}