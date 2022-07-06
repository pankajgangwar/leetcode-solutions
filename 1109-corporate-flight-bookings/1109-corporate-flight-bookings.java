class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n + 2];
        for (int i = 0; i < bookings.length; i++) {
            int s = bookings[i][0];
            int e = bookings[i][1];
            int seats = bookings[i][2];
            res[s] += seats;
            res[e+1] -= seats;
        }
        int sum = 0;
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            sum += res[i];
            ans[i-1] = sum;
        }
        return ans;
    }
}