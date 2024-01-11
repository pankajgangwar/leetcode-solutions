class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] res = new int[n + 1];
        for(int i = 1; i <= n; i++){
            res[i] = gain[i - 1] + res[i - 1];
        }
        return Arrays.stream(res).max().getAsInt();
    }
}