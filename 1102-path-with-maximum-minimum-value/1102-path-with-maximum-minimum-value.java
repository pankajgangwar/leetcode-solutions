class Solution {
    public int maximumMinimumPath(int[][] matrix) {
        return maximumMinimumPathDijkstra2(matrix);
    }
    
    public int maximumMinimumPathUnionFind(int[][] matrix) {
        List<int[]> coord = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                coord.add(new int[]{i,j});
            }
        }
        Collections.sort(coord, (a,b) -> matrix[b[0]][b[1]] - matrix[a[0]][a[1]]);
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[rows][cols];

        UnionFind unionFind = new UnionFind(rows, cols);
        for (int[] curr : coord){
            visited[curr[0]][curr[1]] = true;

            for (int[] dir : dirs){
                int next_x = dir[0] + curr[0];
                int next_y = dir[1] + curr[1];

                if(next_x < 0 || next_x >= rows || next_y < 0 || next_y >= cols || !visited[next_x][next_y])
                    continue;

                unionFind.union(curr[0], curr[1], next_x, next_y);
            }

            if(unionFind.find(0,0) == unionFind.find(rows -1, cols -1)) return matrix[curr[0]][curr[1]];
        }
        return -1;
    }

    class UnionFind {
        private int[] parent, rank;
        int row, col;

        public UnionFind(int rows, int cols) {
            parent = new int[rows * cols];
            rank = new int[rows * cols];
            this.row = rows;
            this.col = cols;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    parent[i* cols + j] = i * cols + j;
                    rank[i * cols + j] = 1;
                }
            }
        }

        public int find(int x, int y) {
            int p = x * col + y;
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int x1, int y1, int x2, int y2) {
            int rootP = find(x1, y1);
            int rootQ = find(x2, y2);
            if (rootP == rootQ) return;//connected
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
        }

    }
    
    public int maximumMinimumPathDijkstra2(int[][] matrix) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> -Integer.compare(a[2], b[2]));
        q.offer(new int[]{0,0, matrix[0][0]});

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        
        while (!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == rows-1 && curr[1] == cols-1) return curr[2];
            for (int[] dir : dirs){
                int next_x = dir[0] + curr[0];
                int next_y = dir[1] + curr[1];
                if(next_x < 0 || next_x >= rows || next_y < 0 || next_y >= cols || visited[next_x][next_y]) continue;
                visited[next_x][next_y] = true;
                q.offer(new int[]{next_x, next_y, Math.min(curr[2], matrix[next_x][next_y]) } );
            }
        }
        return -1;
    }
    
    public int maximumMinimumPathDijkstra1(int[][] matrix) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> -Integer.compare(a[2], b[2]));
        q.offer(new int[]{0,0, matrix[0][0]});

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        visited[0][0] = true;
        int maxScore = matrix[0][0];
        while (!q.isEmpty()){
            int[] curr = q.poll();
            maxScore = Math.min(maxScore, curr[2]);
            if(curr[0] == rows-1 && curr[1] == cols-1) return maxScore;
            
            for (int[] dir : dirs){
                int next_x = dir[0] + curr[0];
                int next_y = dir[1] + curr[1];
                if(next_x < 0 || next_x >= rows || next_y < 0 || next_y >= cols || visited[next_x][next_y]) continue;
                visited[next_x][next_y] = true;
                q.offer(new int[]{next_x, next_y, matrix[next_x][next_y]});
            }
        }
        return -1;
    }
}