class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, 0, new boolean[bikes.length]);
        return min;
    }

    int min = Integer.MAX_VALUE;
    public void dfs(int[][] workers, int[][]bikes, int w, int distance, boolean[] seen){
        if(w >= workers.length){
            min = Math.min(min, distance);
            return;
        }
        if(min < distance){
            return;
        }
        for (int i = 0; i < bikes.length; i++) {
            if(seen[i]) continue;
            seen[i] = true;
            int d = getManhattenDistance(workers[w], bikes[i]);
            dfs(workers, bikes, w + 1, distance + d, seen);
            seen[i] = false;
        }
    }

    public int getManhattenDistance(int[] s, int[] d){
        return Math.abs(s[0] - d[0]) + Math.abs(s[1] - d[1]);
    }
}