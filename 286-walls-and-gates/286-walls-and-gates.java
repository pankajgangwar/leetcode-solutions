class Solution {
    int inf = 2147483647;
    int gate = 0;
    int wall = -1;
    public void wallsAndGates(int[][] rooms) {
        for(int i =0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == gate){
                    bfs(new int[]{i,j}, rooms);
                }
            }
        }
    }
    
    public void bfs(int[] start, int[][] grid){
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(start);
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int dist = 0;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0){
                int[] c = bfs.poll();
                for(int dir = 0; dir < 4; dir++){
                    int next_x = c[0] + dx[dir];
                    int next_y = c[1] + dy[dir];
                    if(isSafe(next_x, next_y, grid)){
                        if(dist + 1 < grid[next_x][next_y]){
                            grid[next_x][next_y] = dist + 1;
                            bfs.offer(new int[]{next_x, next_y});
                        }
                    }
                }
            }
            dist += 1;
        }
    }
    
    public boolean isSafe(int next_x, int next_y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n 
           && grid[next_x][next_y] != wall && grid[next_x][next_y] != gate){
            return true;
        }
        return false;
    }
}