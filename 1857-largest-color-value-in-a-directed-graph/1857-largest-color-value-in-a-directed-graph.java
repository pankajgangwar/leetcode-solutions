class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        LinkedList<Integer>[] g = new LinkedList[n];
        for(int i = 0; i < n; i++) g[i] = new LinkedList<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            indegree[v]++;
            g[u].add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                int idx = colors.charAt(i) - 'a';
                cnt[i][idx]++;
                q.offer(i);
                seen.add(i);
            }
        }
        int max = -1;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int u = q.poll();
                max = Math.max(max, Arrays.stream(cnt[u]).max().getAsInt());
                for(int v : g[u]){
                    if(seen.contains(v)){
                        return -1;
                    }
                    int idx = colors.charAt(v) - 'a';
                    for (int i = 0; i < 26; i++) {
                        cnt[v][i] = Math.max(cnt[v][i], cnt[u][i] + (i == idx ? 1 : 0));
                    }
                    if(--indegree[v] == 0){
                        q.offer(v);
                        seen.add(v);
                    }
                }
            }
        }
        return seen.size() < n ? -1 : max;
    }
}