class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        List<Integer> res = new ArrayList<>();

        if (n==1) {
            res.add(0);
            return res;
        }

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        int[] degrees = new int[n];

        for(int[] edge : edges){
            
            int first = edge[0];
            int second = edge[1];
            
            graph[first].add(second);
            graph[second].add(first);

            degrees[first]++;
            degrees[second]++;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        for(int i = 0; i < n; i++){
            if(degrees[i] == 0)
                return res;
            else if(degrees[i] == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                
                res.add(curr);
                degrees[curr]--;

                for(int idx = 0; idx < graph[curr].size(); idx++){
                    int next = graph[curr].get(idx);
                    if(degrees[next] == 0) continue;
                    if(degrees[next] == 2){
                        queue.offer(next);
                    }
                    degrees[next]--;
                }    
            }
        }
        return res;
    }
}