class Solution {
    
    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
    Set<String> blockedSet = new HashSet<>();
    for (int[] b : blocked)
      blockedSet.add(b[0] + "," + b[1]);

    return dfs(blockedSet, s[0], s[1], t ,new HashSet<>()) &&
        dfs(blockedSet, t[0], t[1], s, new HashSet<>());
  }

  private boolean dfs(Set<String> blockedSet, int i, int j, int[] target, Set<String> visited) {
     String key = i + "," + j;
    if (i < 0 || i >= 1e6 || j < 0 || j >= 1e6 || blockedSet.contains(key) ||
        visited.contains(key))
      return false;

    visited.add(key);
    if (visited.size() > (1 + 199) * 199 / 2 || (i == target[0] && j == target[1]))
      return true;

    return                                            
        dfs(blockedSet, i + 1, j, target, visited) || 
        dfs(blockedSet, i - 1, j, target, visited) || 
        dfs(blockedSet, i, j + 1, target, visited) || 
        dfs(blockedSet, i, j - 1, target, visited);
  }

    public boolean isEscapePossible11(int[][] blocked, int[] s, int[] t) {
        HashSet<String> blocker = new HashSet<>();
        for (int[] b : blocked) {
            blocker.add(b[0] + "," + b[1]);
        }

        return bfs(s, t, blocker) && bfs(t, s, blocker);
        //return dfs(s, t, s, new HashSet<>(), blocker) && dfs(t, s, t, new HashSet<>(), blocker);
    }

    public boolean dfs(int[] s, int[] t, int[] c, HashSet<String> visited,
                   HashSet<String> blocked){
        if(c[0] == t[0] && c[1] == t[1]) return true;

        if(Math.abs(s[0] - c[0]) + Math.abs(s[1] - c[1]) > 200){
             return true;
        }
        visited.add(c[0] + "," + c[1]);

        int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int d[] : dirs) {
            int row = d[0] + c[0];
            int col = d[1] + c[1];
            String next = row + "," + col;
            if(row >= 0 && row < (100_00_00) 
               && col > 0 && col < (100_00_00)
               && !blocked.contains(next) && !visited.contains(next)){
                if(dfs(s, t, new int[]{row, col}, visited, blocked)){
                    return true;
                }
            }
        }
        return false;
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