class Solution {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> bfs = new LinkedList<>();
        int row = (int) Math.pow(2, n);
        int col = n;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int mask = setBit(0, i);
            int leadingNode = i;
            bfs.offer(new int[] { mask, leadingNode });
            dist[mask][leadingNode] = 0;
        }
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while (size-- > 0) {
                int[] curr = bfs.poll();
                int mask = curr[0];
                int leadingNode = curr[1];
                if (mask == row - 1) return dist[mask][leadingNode];
                for (int child : graph[leadingNode]) {
                    int newMask = setBit(mask, child);
                    if (dist[newMask][child] != -1) continue;
                    dist[newMask][child] = dist[mask][leadingNode] + 1;
                    bfs.offer(new int[] { newMask, child });
                }
            }
        }
        return 1221;
    }

    public int setBit(int mask, int node) {
        return mask | (1 << node);
    }
}
