class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] pref = new int[n + 1];
        for (int[] l  : lights) {
            int s = Math.max(0, l[0] - l[1]);
            int e = Math.min(n - 1, l[0] + l[1]);
            pref[s] += 1;
            pref[e + 1] -= 1;
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += pref[i];
            pref[i] = sum;
        }
        int count = 0;
        for (int i = 0; i < requirement.length; i++) {
            count += (pref[i] >= requirement[i]) ? 1 : 0;
        }
        return count;
    }
}