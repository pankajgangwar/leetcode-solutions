class Solution {
    public int minimumEffortPath(int[][] matrix) {
        //return minimumEffortPathDijikstra(matrix);
        return minimumEffortPathBinarySearch(matrix);
    }
    
    public int minimumEffortPathDijikstra(int[][] matrix) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()){
            int size = pq.size();
            while (size-- > 0){
                int[] curr = pq.poll();
                int currD = curr[0];
                int curr_x = curr[1];
                int curr_y = curr[2];
                if(curr_x == m - 1 && curr_y == n - 1) {
                    return currD;
                }
                for (int[] d : dirs) {
                    int next_x = d[0] + curr_x;
                    int next_y = d[1] + curr_y;
                    if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n){
                        int newDistance = Math.max(currD, Math.abs(matrix[curr_x][curr_y] - matrix[next_x][next_y]));
                        if(distance[next_x][next_y] > newDistance){
                            distance[next_x][next_y] = newDistance;
                            pq.offer(new int[]{newDistance, next_x, next_y});
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int minimumEffortPathBinarySearch(int[][] matrix) {
        int low = 0, high = 1000_000;
        while (low < high){
            int mid = low + ((high - low) / 2);
            if(search(mid, matrix)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean search(int maxEffortAllowed, int[][] matrix){
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] curr = queue.poll();
                if(curr[0] == m - 1 && curr[1] == n - 1){
                    return true;
                }
                for (int[] d : dirs){
                    int next_x = d[0] + curr[0];
                    int next_y = d[1] + curr[1];
                    if(next_x >= 0 && next_x < m && next_y >= 0 & next_y < n && !visited[next_x][next_y]){
                        if(Math.abs(matrix[curr[0]][curr[1]] - matrix[next_x][next_y]) <= maxEffortAllowed){
                            queue.offer(new int[]{next_x, next_y});
                            visited[next_x][next_y] = true;
                        }
                    }
                }
            }
        }
        return false;
    }

}