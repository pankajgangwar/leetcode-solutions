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

}