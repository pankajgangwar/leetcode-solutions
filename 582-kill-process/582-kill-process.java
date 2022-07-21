class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < pid.size(); i++){
            int parent = ppid.get(i);
            int child = pid.get(i);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);
        }
        List<Integer> killed = new ArrayList<>();
        dfs(graph, kill, killed);
        return killed;
    }


    public void dfs(HashMap<Integer, List<Integer>> graph, int src, List<Integer> killed) {
        killed.add(src);
        if(!graph.containsKey(src)) return;
        for(int pid : graph.get(src)){
            dfs(graph, pid, killed);
        }
    }
    
}