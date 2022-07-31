class Solution {
    
    public int longestCycle1(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int idx = i, dist = 0; idx != -1; idx = edges[idx]){
                if(map.containsKey(idx)){
                    ans = Math.max(ans, dist - map.get(idx));
                    break;
                }
                if(visited[idx]) break;
                visited[idx] = true;
                map.put(idx, dist++);
            }
        }
        return ans;
    }
    
     public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                int len = findCycleLength(edges, i, visited);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public int findCycleLength(int[] edge, int curr, boolean[] visited) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dist = 0;
        while(curr != -1){
            if(map.containsKey(curr)) {
                return dist - map.get(curr);
            }
            if(visited[curr]) {
                return -1;
            }
            visited[curr] = true;
            map.put(curr, dist++);
            curr = edge[curr];
        }
        return curr == -1 ? curr : dist;
    }
    
}