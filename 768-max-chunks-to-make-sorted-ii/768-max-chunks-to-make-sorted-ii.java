class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n ; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }
        minOfRight[n-1] = arr[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            minOfRight[i] = Math.min(arr[i], minOfRight[i+1]);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if(maxOfLeft[i] <= minOfRight[i+1]) ans++;
        }
        return ans;
    }
}