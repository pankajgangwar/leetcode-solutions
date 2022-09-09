class Solution {
    public int earliestAcq(int[][] logs, int N) {
        int[] parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        
        for(int i = 0; i < logs.length; i++){
            int a = logs[i][1];
            int b = logs[i][2];
            
            int aRoot = find(parent, a);
            int bRoot = find(parent, b);
            if(aRoot != bRoot){
                parent[aRoot] = bRoot;
                N--;
            }
            if(N == 1){
                return logs[i][0];
            }
        }
        return -1;
    }
    
    public int find(int[] parent, int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}