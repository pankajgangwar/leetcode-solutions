class Solution {
        public double[] calcEquation(List<List<String>> equations, 
                                     double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());

            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1.0 / value);
        }

        double[] results = new double[queries.size()];

        // Perform DFS for each query
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);

            results[i] = dfs(graph, numerator, denominator, new HashSet<>());
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), end, visited);
                if (result != -1.0) {
                    return result * neighbor.getValue();
                }
            }
        }

        return -1.0;
    }
    
    public double[] calcEquation1(List<List<String>> e, double[] v, List<List<String>> q) {
        double[] result = new double[q.size()];
        HashMap<String, Double> dist = new HashMap<>();
        HashMap<String, String> root = new HashMap<>();      

        for(int i = 0; i < e.size(); i++){
            List<String> curr = e.get(i);
            String a = curr.get(0);
            String b = curr.get(1);

            String parent_a = findParent(a, dist, root);
            String parent_b = findParent(b, dist, root);

            root.put(parent_a, parent_b);
            dist.put(parent_a, dist.get(b) * v[i] / dist.get(a));
        }

        for(int i =0; i < q.size(); i++){
            List<String> curr = q.get(i);
            
            String a = curr.get(0);
            String b = curr.get(1);

            if(!root.containsKey(a) || !root.containsKey(b)){
                result[i] = -1.0;
                continue;
            }

            String parent_a = findParent(a, dist, root);
            String parent_b = findParent(b, dist, root);

            if(!parent_a.equals(parent_b)){ //Not in same set
                result[i] = -1.0;
                continue;
            }

            result[i] = (double) dist.get(a) / dist.get(b);
        }

        return result;
    }

    public String findParent(String s, HashMap<String, Double> dist, HashMap<String, String> root){
        if(!root.containsKey(s)){
            dist.put(s, 1.0);
            root.put(s, s);
            return s;
        }
        if(root.get(s).equals(s)) return s;
        String last_parent = root.get(s);
        String parent = findParent(last_parent, dist, root);
        root.put(s, parent);
        dist.put(s, dist.get(s) * dist.get(last_parent));
        return parent;
    }
}