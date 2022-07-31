class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int n = grades.length;
        int low = 1, high = 446;
        int g = 1;
        while (low <= high){
            int m = low + (high - low) / 2;
            if(m * (m + 1) / 2 <= n){
                g = m;
                low = m + 1;
            }else{
                high = m - 1;
            }
        }
        return g;
    }
}