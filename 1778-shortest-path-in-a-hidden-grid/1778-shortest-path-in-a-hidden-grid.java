/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    int[][] dxys = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[] dirs = new char[] {'U', 'D', 'L', 'R'};
    char[] rev_dirs = new char[] {'D', 'U', 'R', 'L'};

    int[] target = new int[]{-100, -100};
    int m = 501;
    int s = m - 1;
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[m*2][m*2];
        for (int i = 0; i < (m*2); i++) {
            Arrays.fill(grid[i], -1);
        }
        grid[s][s] = 0;
        fillGrid(s, s, grid, master);
        boolean[][] visited = new boolean[m*2][m*2];

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{s, s});

        int steps = 0;
        while (!pq.isEmpty()){
            int size = pq.size();
            while(size-- > 0){
                int[] curr = pq.poll();
                int curr_x = curr[0], curr_y = curr[1];
                if(curr_x == target[0] && curr_y == target[1]){
                    return steps;
                }
                if(visited[curr_x][curr_y]) continue;
                visited[curr_x][curr_y] = true;
                for (int i = 0; i < dxys.length; i++) {
                    int next_x = dxys[i][0] + curr_x;
                    int next_y = dxys[i][1] + curr_y;
                    if(next_x < 0 || next_x >= grid.length
                            || next_y < 0 || next_y >= grid[0].length
                            || visited[next_x][next_y] || grid[next_x][next_y] == -1){
                        continue;
                    }
                    pq.offer(new int[]{next_x, next_y});
                }
            }
            steps++;
        }
        return -1;
    }

    private void fillGrid(int currX, int currY,
                          int[][] grid, GridMaster master) {
        if(master.isTarget()){
            target[0] = currX;
            target[1] = currY;
        }

        for (int i = 0; i < dirs.length; i++) {
            char ch = dirs[i];
            char revCh = rev_dirs[i];
            int next_x = currX + dxys[i][0];
            int next_y = currY + dxys[i][1];
            if(next_x >= grid.length || next_x < 0 || next_y < 0 || next_y >= grid[0].length){
                continue;
            }
            if(master.canMove(ch) && grid[next_x][next_y] == -1){
                master.move(ch);
                grid[next_x][next_y] = 1;
                fillGrid(next_x, next_y, grid, master);
                master.move(revCh);
            }
        }
    }
}