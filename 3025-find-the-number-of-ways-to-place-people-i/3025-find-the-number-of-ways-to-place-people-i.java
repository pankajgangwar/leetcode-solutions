class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? -a[1] + b[1] : a[0] - b[0]);
        int ans = 0;
        for(int i = 0; i < points.length; ++i){
            for(int j = i+1; j < points.length; ++j){
                if(points[i][1] >= points[j][1]){
                    boolean flag = true;
                    for(int k = i+1; k < j; ++k){
                        if(points[k][1] <= points[i][1] && points[k][1] >= points[j][1] ) flag = false;
                    }
                    if(flag) ans++;
                }
            }
        }
        return ans;
    }
}