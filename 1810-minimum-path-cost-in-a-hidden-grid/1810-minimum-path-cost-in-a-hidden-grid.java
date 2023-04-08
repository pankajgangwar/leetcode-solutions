/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     int move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
 	int[][] dxys = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[] dirs = new char[] {'U', 'D', 'L', 'R'};
    int[] target = new int[]{-100, -100};
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[200][200];
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                grid[i][j] = -1;
            }
        }
        grid[99][99] = 0;
        fillGrid(99, 99, grid, master);
        boolean[][] visited = new boolean[200][200];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{99, 99, 0});
        while (!pq.isEmpty()){
                int[] curr = pq.poll();
                int curr_x = curr[0], curr_y = curr[1], cost = curr[2];
                if(curr_x == target[0] && curr_y == target[1]){
                    return cost;
                }
                visited[curr_x][curr_y] = true;
                for (int i = 0; i < dxys.length; i++) {
                     int next_x = dxys[i][0] + curr_x;
                     int next_y = dxys[i][1] + curr_y;
                     if(next_x < 0 || next_x >= grid.length
                             || next_y < 0 || next_y >= grid[0].length
                             || visited[next_x][next_y] || grid[next_x][next_y] == -1){
                         continue;
                     }
                     int nextCost = cost + grid[next_x][next_y];
                     pq.offer(new int[]{next_x, next_y, nextCost});
                }
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
                int next_x = currX + dxys[i][0];
                int next_y = currY + dxys[i][1];
                if(next_x >= grid.length || next_x < 0 || next_y < 0 || next_y >= grid[0].length){
                    continue;
                }
                if(master.canMove(ch) && grid[next_x][next_y] == -1){
                    grid[next_x][next_y] = master.move(ch);
                    fillGrid(next_x, next_y, grid, master);
                    if (i == 0 || i == 1) {
                        master.move(dirs[1 - i]);
                    } else {
                        master.move(dirs[5 - i]);
                    }
                }
            }
        }
}