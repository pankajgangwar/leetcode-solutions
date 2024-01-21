class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> mQueue = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    mQueue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while (!mQueue.isEmpty()){
            int[] curr = mQueue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int next_x = curr[0] + dirs[i][0];
                int next_y = curr[1] + dirs[i][1];
                if(next_x < 0 || next_x >= rows || next_y < 0 || next_y >= cols ||
                    matrix[curr[0]][curr[1]] +1 >= matrix[next_x][next_y]) continue;
                mQueue.offer(new int[]{next_x, next_y});
                matrix[next_x][next_y] = matrix[curr[0]][curr[1]] + 1;
            }
        }
        return matrix;
    }
}