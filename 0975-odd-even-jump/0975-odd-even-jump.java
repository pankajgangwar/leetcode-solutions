class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr.length;
        boolean[][] dp = new boolean[n][2];
        /*
        dp[i][0] stands for you can arrive index n - 1 starting from index i at an odd step.
        dp[i][1] stands for you can arrive index n - 1 starting from index i at an even step.
        */
        dp[n-1][0] = true;
        dp[n-1][1] = true;
        map.put(arr[n-1], n-1);
        int res = 1;
        for (int i = n-2; i >= 0; --i) {
            Integer nextGreaterElement = map.ceilingKey(arr[i]);
            if(nextGreaterElement != null){
                dp[i][0] = dp[map.get(nextGreaterElement)][1];
            }
            Integer nextSmallerElement = map.floorKey(arr[i]);
            if(nextSmallerElement != null){
                dp[i][1] = dp[map.get(nextSmallerElement)][0];
            }
            map.put(arr[i], i);
            res += dp[i][0] ? 1 : 0; // Since we started with odd i.e 1
        }
        return res;
    }
}