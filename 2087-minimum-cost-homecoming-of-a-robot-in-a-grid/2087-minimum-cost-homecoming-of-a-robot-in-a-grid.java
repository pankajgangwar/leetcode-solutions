class Solution {
    public int minCost(int[] s, int[] h, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        int dr = s[0] < h[0] ? 1 : - 1;
        int dc = s[1] < h[1] ? 1 : - 1;
        for (int i = s[0]; i != h[0]; i+= dr) {
            cost += rowCosts[i + dr];
        }

        for (int i = s[1]; i != h[1]; i+= dc) {
            cost += colCosts[i + dc];
        }
        return cost;
    }
}