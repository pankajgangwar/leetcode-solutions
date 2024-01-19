class Solution {
    
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] + "," + block[1]);
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private static boolean bfs(int[] source, int[] target, Set<String> blockedSet) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source[0] + "," + source[1]);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                String key = nx + "," + ny;
                if(Math.abs(source[0] - nx) + Math.abs(source[1] - ny) > 200){
                    return true;
                }

                if (nx >= 0 && nx < 1000000 && ny >= 0 && ny < 1000000 && !blockedSet.contains(key) && !visited.contains(key)) {
                    if (nx == target[0] && ny == target[1]) {
                        return true;
                    }

                    visited.add(key);
                    queue.offer(new int[]{nx, ny});
                    
                }
            }
        }

        return false;
    }
    
    public boolean isEscapePossible1(int[][] blocked, int[] s, int[] t) {
        HashSet<String> blockers = new HashSet<>();
        for(int[] b : blocked){
            blockers.add(b[0] + "," + b[1]);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(s);

        HashSet<String> visited = new HashSet<>();
        visited.add(s[0] + "," + s[1]);

        int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] c = q.poll();
            if(Arrays.equals(c, t )) return true;
            for(int i = 0; i < dirs.length; i++){
                int next_x = dirs[i][0] + c[0];
                int next_y = dirs[i][1] + c[1];
                int[] next = new int[]{next_x, next_y};
                String key = next[0] + "," + next[1];
                if(next_x < 0 || next_x >= (100_00_00) || next_y < 0 || next_y >= (100_00_00)
                        || blockers.contains(key) || visited.contains(key)){
                    return false;
                }
                /*
                if(next_x >= 0 && next_x < (100_00_00) && next_y >= 0 && next_y < (100_00_00)
                        && !blockers.contains(key) && visited.add(key)){
                    q.offer(next);
                    if (visited.size() == blockers.size()) {
                        return true;
                    }
                }
                */
            }
        }
        return false;
    }    
    
}