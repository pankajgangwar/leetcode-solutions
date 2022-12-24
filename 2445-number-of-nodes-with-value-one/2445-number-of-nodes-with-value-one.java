class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int[] tree = new int[n + 1];
        for(int q : queries){
            tree[q]++;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            tree[i] += tree[i / 2];
            count += tree[i] % 2;
        }
        return count;
    }
}