class Solution {
    
    public boolean isEscapePossible1111(int[][] blocked, int[] s, int[] t) {
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
    if (visited.size() > 20000 || (i == target[0] && j == target[1]))
      return true;

      int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int d[] : dirs) {
            int row = d[0] + i;
            int col = d[1] + j;
            String next = row + "," + col;
            if(dfs(blockedSet, row, col, target, visited)){
                return true;
            }
        }
      return false;
  }

    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
        HashSet<String> blocker = new HashSet<>();
        for (int[] b : blocked) {
            blocker.add(b[0] + "," + b[1]);
        }

        //return bfs(s, t, blocker) && bfs(t, s, blocker);
        return dfs(s, t, new HashSet<>(), blocker) && dfs(t, s, new HashSet<>(), blocker);
    }

    public boolean dfs(int[] s, int[] t, HashSet<String> visited,
                   HashSet<String> blocked){
        String key = s[0] + "," + s[1];
        if(s[0] < 0 || s[0] >= 1e6 
               || s[1] < 0 || s[1] >= (1e6)
               || blocked.contains(key)  
               || visited.contains(key)){
            return false;
        }
        visited.add(key);
        if((s[0] == t[0] && s[1] == t[1]) || visited.size() > 20000) return true;
        
        int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int d[] : dirs) {
            int row = d[0] + s[0];
            int col = d[1] + s[1];
            if(dfs(new int[]{row, col}, t, visited, blocked)){
                return true;
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