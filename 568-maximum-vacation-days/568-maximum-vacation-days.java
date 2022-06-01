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
        //System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
    
    //todo : debug the code
     public int maxVacationDays1(int[][] flights, int[][] days) {
        int n = flights.length;
        int weeks = days[0].length;

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < flights[i].length; j++) {
                if(flights[i][j] == 1) {
                    graph[j].add(i);
                }
            }
        }
        int[][] dp = new int[n][weeks];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = days[i][0];
        }
        for (int w = 1; w < weeks; w++) {
            for (int cityi = 0; cityi < n; cityi++) {
                LinkedList<Integer> connectedCities = graph[cityi];
                if(connectedCities.isEmpty()){
                    dp[cityi][w] = dp[cityi][w - 1] + days[cityi][w];
                    continue;
                }
                int max = 0;
                for(int prev : connectedCities){
                    max = Math.max(max, days[cityi][w] + dp[prev][w-1]);
                }
                dp[cityi][w] = Math.max(dp[cityi][w], max);
            }
        }
        int max = 0;
        for (int city = 0; city < n; city++) {
            System.out.println(" " + Arrays.toString(dp[city]));
            max = Math.max(max, dp[city][weeks - 1]);
        }
        return max;
    }

}