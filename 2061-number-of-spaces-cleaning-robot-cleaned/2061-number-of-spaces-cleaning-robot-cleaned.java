class Solution {
    private int m, n, r, c, d = 1;
    private int[][] dirs = new int[][] { {}, {0,1}, {1,0}, {0,-1}, {-1,0}  };
    
    public int numberOfCleanRooms(int[][] room) {
        this.m = room.length;
        this.n = room[0].length;
        int[][] visited = new int[m][n];
        
        int count = 0;
        while (true) {
            if (isOutOfBounds() || room[r][c] == 1) {
                turnRight();
                continue;
            }
            
            if (visited[r][c] == d) return count;

            if (visited[r][c] == 0) {
                visited[r][c] = d;
                count++;
            }
            
            r += dirs[d][0];
            c += dirs[d][1];
        }
    }
    
    private boolean isOutOfBounds() {
        return r < 0 || r == m || c < 0 || c == n;
    }

    private void turnRight() {
        r -= dirs[d][0];
        c -= dirs[d][1];
        d = (d % 4) + 1;        
    }
    
    public int numberOfCleanRooms1(int[][] room) {
        int m = room.length;
        int n = room[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, room, visited, Direction.RIGHT) + 1;
    }

    int dfs(int cx, int cy, int[][] room,
            boolean[][] visited, Direction dir){
        int m = room.length;
        int n = room[0].length;
        
        if(room[cx][cy] == 1) return 0;
        room[cx][cy] = 1;
        
        int nr = cx + dir.currD[0];
        int nc = cy + dir.currD[1];
        int cleaned = 1;
        if(nr >= 0 && nr < m && nc >= 0 && nc < n && room[nr][nc] == 0){
            cleaned += dfs(nr, nc, room, visited, dir);
        }else {
            char d = dir.c;
            nr = cx + dir.nextD[0];
            nc = cy + dir.nextD[1];
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || room[nr][nc] == 1){
                return 0;
            }
            switch (d){
                case 'U':
                    cleaned += dfs(nr, nc, room, visited, Direction.RIGHT);
                    break;
                case 'L':
                    cleaned += dfs(nr, nc, room, visited, Direction.UP);
                    break;
                case 'D':
                    cleaned += dfs(nr, nc, room, visited, Direction.LEFT);
                    break;
                case 'R':
                    cleaned += dfs(nr, nc, room, visited, Direction.DOWN);
                    break;
            }
        }
        return cleaned;
    }

    enum Direction {
        UP('U', 'R', new int[]{-1,0}, new int[]{0,1}),
        DOWN('D', 'L',new int[]{1,0}, new int[]{0,-1}),
        LEFT('L', 'U', new int[]{0,-1}, new int[]{-1,0}),
        RIGHT('R', 'D', new int[]{0,1}, new int[]{1,0});

        public char c;
        public char o;
        public int[] nextD;
        public int[] currD;

        Direction(char c, char o, int[] currD, int[] nextD) {
            this.c = c;
            this.o = o;
            this.nextD = nextD;
            this.currD = currD;
        }
    }
    
}