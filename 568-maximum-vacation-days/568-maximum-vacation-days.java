class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int weeks = days[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int w = 0; w < weeks; w++) {
            int[] temp = new int[n];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int cityi = 0; cityi < n; cityi++) {
                for (int cityj = 0; cityj < n; cityj++) {
                    if( cityi == cityj || flights[cityj][cityi] == 1){
                        temp[cityi] = Math.max(temp[cityi], dp[cityj] + days[cityi][w]);
                    }
                }
            }
            dp = temp;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}