class Solution {
    
    public int minimumSemestersI(int N, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<>(); // key: prerequisite, value: course list. 
        int[] inDegree = new int[N + 1]; // inDegree[i]: number of prerequisites for i.
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); // construct graph.
            ++inDegree[r[1]]; // count prerequisites for r[1].
        }
        Queue<Integer> q = new LinkedList<>(); // save current 0 in-degree vertices.
        for (int i = 1; i <= N; ++i)
            if (inDegree[i] == 0)
                q.offer(i);
        int semester = 0;
        while (!q.isEmpty()) { // BFS traverse all currently 0 in degree vertices.
            for (int sz = q.size(); sz > 0; --sz) { // sz is the search breadth.
                int c = q.poll();
                --N;
                if (!g.containsKey(c)) continue; // c's in-degree is currently 0, but it has no prerequisite.
                for (int course : g.remove(c))
                    if (--inDegree[course] == 0) // decrease the in-degree of course's neighbors.
                        q.offer(course); // add current 0 in-degree vertex into Queue.
            }
            ++semester; // need one more semester.
        }
        return N == 0 ? semester : -1;
    }
    
    public int minimumSemesters(int N, int[][] relations) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        int[] indegree = new int[N + 1];
        for(int[] c : relations){
            g.putIfAbsent(c[0], new ArrayList<>());
            g.get(c[0]).add(c[1]);
            ++indegree[c[1]];
        }
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0){
                bfs.add(i);
            }
        }
        int res = 0;
        while (!bfs.isEmpty()){
            int sz = bfs.size();
            while (sz-- > 0){
                N--;
                List<Integer> nextCourses = g.getOrDefault(bfs.poll(), new ArrayList<>());
                for(int c : nextCourses){
                    if(--indegree[c] == 0){
                        bfs.offer(c);
                    }
                }
            }
            ++res;
        }
        return N == 0 ? res : -1;
    }

    
    public int minimumSemesters2(int N, int[][] relations) {
        int[] indegree = new int[N+1];
        
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int[] curr : relations){
            graph.putIfAbsent(curr[0], new ArrayList<Integer>());
            graph.get(curr[0]).add(curr[1]);
            indegree[curr[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int semesters = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                --N;
                int curr = q.poll();
                if(!graph.containsKey(curr)) continue;
                List<Integer> adj = graph.get(curr);
                for(int i = 0; i < adj.size(); i++){
                    int next = adj.get(i);
                     if(--indegree[next] == 0){
                         q.offer(next);
                     }
                }
            }
            semesters++;
        }
        return N == 0 ? semesters : -1;
    }
}