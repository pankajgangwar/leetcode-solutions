class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] right = new int[n];

        for (int i = n - 1, rr = 0;  i >=0 ; i--) {
            rr += possible[i] == 1 ? 1 : -1;
            right[i] = rr;
        }
        for (int i = 0, curr = 0; i < n - 1; i++) {
            curr += possible[i] == 1 ? 1 : -1;
            if(curr > right[i + 1]) return (i + 1);
        }
        return -1;
    }
}