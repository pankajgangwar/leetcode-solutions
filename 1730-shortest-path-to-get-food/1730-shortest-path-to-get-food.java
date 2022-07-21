class Solution {
    public int getFood(char[][] grid) {
        int[] start = new int[]{-1,-1};
        int[] target = new int[]{-1,-1};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    grid[i][j] = 'X';
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        if(start[0] == -1) return -1; 
        
        return bfs(start, grid);
    }
    
    public int bfs(int[] start, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        visited[start[0]][start[1]] = true;
        
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int curr_x = curr[0];
                int curr_y = curr[1];
                if(grid[curr_x][curr_y] == '#'){
                    return dist;
                }
                grid[curr_x][curr_y] = 'X';
                for(int i = 0; i < 4; i++){
                    int next_x = dx[i] + curr[0];
                    int next_y = dy[i] + curr[1];
                    if(next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length || grid[next_x][next_y] == 'X' || visited[next_x][next_y]) continue;
                    
                    q.offer(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
            dist += 1;
        }
        return -1;
    }
}