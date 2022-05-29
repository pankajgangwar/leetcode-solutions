class Solution {
    
     public int racecar(int t) {
         return racecarBfs1(t);
     }
    
    public int racecarBfs1(int target) {
        Queue<int[]> bfs = new LinkedList<>();
        int[] start = new int[]{0,0,1,};
        bfs.offer(start); // pos, speed
        while (!bfs.isEmpty()){
            int[] curr = bfs.poll();
            int moves = curr[0];
            int pos = curr[1];
            int vel = curr[2];
            if(pos == target) return moves;
            if(Math.abs(pos) > 2 * target) continue;
            bfs.offer(new int[]{moves + 1, pos + vel, vel * 2});
            if(((pos + vel) > target && vel > 0) || (pos + vel < target && vel < 0)){
                bfs.offer(new int[]{moves+1, pos, vel > 0 ? -1 : 1});
            }
        }
        return 0;
    }
    
    int dp[] = new int[10001];
    public int racecarDp(int t) {
        if(dp[t] > 0) return dp[t];
        int n = (int)(Math.log(t) / Math.log(2)) + 1;
        if(1 << n == t + 1){
            dp[t] = n;
        }else{
            dp[t] = racecarDp((1<<n) - 1 - t) + n + 1;
            for (int m = 0; m < n - 1; ++m){
                dp[t] = Math.min(dp[t], racecarDp(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
        }
        return dp[t];
    }
    
    public int racecarBfs(int target) {
        Queue<int[]> bfs = new LinkedList<>();
        int[] start = new int[]{0,1};
        bfs.offer(start); // pos, speed
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(Arrays.toString(start));
        while (!bfs.isEmpty()){
            int size = bfs.size();
            while (size-- > 0){
                int[] curr = bfs.poll();
                if(curr[0] == target) return level;
                int[] op1 = new int[]{curr[0] + curr[1], curr[1] * 2};
                int[] op2 = new int[]{curr[0], curr[1] > 0 ? -1 : 1};
                if(Math.abs(op1[0] - target) < target && !visited.contains(Arrays.toString(op1))){
                    visited.add(Arrays.toString(op1));
                    bfs.offer(op1);
                }
                if(Math.abs(op2[0] - target) < target && !visited.contains(Arrays.toString(op2))){
                    visited.add(Arrays.toString(op2));
                    bfs.offer(op2);
                }
            }
            level += 1;
        }
        return 0;
    }

}