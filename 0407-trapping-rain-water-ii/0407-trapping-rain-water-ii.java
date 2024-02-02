class Solution {
    public class Cell {
        int row, col, height;
        public Cell(int r, int c, int h){
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }

    public int trapRainWater(int[][] heights) {
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return 0;
        }

        PriorityQueue<Cell> q = new PriorityQueue<Cell>( (a,b) -> a.height - b.height );

        int m = heights.length;
        int n = heights[0].length;
        boolean[][]visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            q.offer(new Cell(i, 0, heights[i][0]));
            q.offer(new Cell(i, n-1, heights[i][n-1]));
        }

        for(int j = 0; j < n; j++){
            visited[0][j] = true;
            visited[m-1][j] = true;
            q.offer(new Cell(0, j, heights[0][j]));
            q.offer(new Cell(m-1, j, heights[m-1][j]));
        }

        int[][] dirs = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        int res = 0;
        while(!q.isEmpty()){
            Cell curr = q.poll();
            for(int[]dir : dirs){
                int next_x = curr.row + dir[0];
                int next_y = curr.col + dir[1];
                int h = curr.height;

                if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && !visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    res += Math.max(0, h - heights[next_x][next_y]);
                    q.offer(new Cell(next_x, next_y, Math.max(h, heights[next_x][next_y])));
                }
            }
        }
        return res;
    }
}