class Solution {
    int[][] dirs = new int[][]{{1,0},/*right*/
                                   {0,1},/* top*/ 
                                   {-1,0}, /* left */
                                   {0,-1}, /* bottom */
                                   };
        
    
    public boolean hasPath(int[][] maze, int[] s, int[] d) {
        
        int m = maze.length;
        int n = maze[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        //return bfs(maze, visited, s, d); //slow
        return helper(maze, visited, s, d); //fast
    }
    
    public boolean bfs(int[][] maze, boolean[][] visited, int[] s, int[] d){
        Queue<int[]> q = new LinkedList<>();
        q.offer(s);

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(Arrays.equals(curr, d)) return true;
            visited[curr[0]][curr[1]] = true;

            for(int[] dir : dirs) {
                int next_x = dir[0];
                int next_y = dir[1];

                int[] next = roll(maze, curr[0], curr[1], next_x, next_y);
                if(visited[next[0]][next[1]]) continue;
                q.offer(next);
            }
        }
        return false;
    }
    
    public boolean helper(int[][] maze, boolean[][] visited, int[] s, int[] d){
        if(visited[s[0]][s[1]]) return false;
        if(Arrays.equals(s, d)) return true;
        
        visited[s[0]][s[1]] = true;
        
        for(int[] dir :  dirs){
            int next_x = dir[0];
            int next_y = dir[1];
            
            int[] newStart = roll(maze, s[0], s[1], next_x, next_y);
            if(helper(maze, visited, newStart, d)){
                return true;
            }
        }
        return false;
    }
    
    public int[] roll(int[][] maze, int x, int y, int rowInc, int colInc){
        while(ifCanRoll(maze, x + rowInc, y + colInc)){
            x += rowInc;
            y += colInc;
        }
        return new int[]{x, y}; // Return new start
    }
    
    public boolean ifCanRoll(int[][] maze, int x, int y){
        int m = maze.length;
        int n = maze[0].length;
        if(x >=0 && x < m && y >= 0 && y < n && maze[x][y] == 0)
            return true;
        
        return false;
    }
}