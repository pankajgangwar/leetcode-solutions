class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][]prefix = new int[n + 1][101];
        int[]cnt = new int[101];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
            for (int j = 1; j < 101 ; j++) {
                prefix[i+1][j] = cnt[j];
            }
        }
        int q = queries.length;
        int[]res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            cnt = new int[101];
            for (int j = 1; j < 101 ; j++) {
                cnt[j] = prefix[r+1][j] - prefix[l][j];
            }
            int prev = -1, minAbs = Integer.MAX_VALUE;
            for (int j = 1; j < 101 ; j++) {
                if(cnt[j] == 0) continue;
                if(prev != -1 && j - prev < minAbs ) {
                    minAbs = j - prev;
                }
                prev = j;
            }
            res[i] = minAbs == Integer.MAX_VALUE ? -1 : minAbs;
        }
        return res;
    }
}