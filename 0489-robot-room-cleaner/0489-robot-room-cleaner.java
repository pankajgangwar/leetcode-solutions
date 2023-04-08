/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, new HashSet<>(), 0, 0, 0);
        return;
    }
    public void dfs(Robot robot, Set<String> visited, int curr_x, int curr_y, int arrow){
        robot.clean();
        int dir[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //clockwise direction
        for (int i = 0; i < 4; i++) {
            int next_x = dir[arrow][0] + curr_x;
            int next_y = dir[arrow][1] + curr_y;
            String path = next_x + "->" + next_y;
            if(!visited.contains(path) && robot.move()){
                visited.add(path);
                dfs(robot, visited, next_x, next_y, arrow);
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
    
}