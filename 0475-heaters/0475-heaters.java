class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int h = houses[i];
            int idx = Arrays.binarySearch(heaters, h);
            if(idx < 0) {
                idx = ~idx;
            }
            int distLeft = idx - 1 >= 0 ? h - heaters[idx - 1] : Integer.MAX_VALUE;
            int distRight = idx < heaters.length ? heaters[idx] - h : Integer.MAX_VALUE;
            ans = Math.max(ans, Math.min(distLeft, distRight));
        }
        return ans;
    }
}