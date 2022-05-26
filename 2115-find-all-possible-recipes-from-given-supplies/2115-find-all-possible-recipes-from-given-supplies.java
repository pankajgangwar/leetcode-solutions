class Solution {
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        return topologicalSort(recipes, ingredients, supplies);
    }

    public List<String> topologicalSort(String[] recipes, List<List<String>> ingredients, String[] supplies){
        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> sup = new HashSet<>(Arrays.asList(supplies));
        HashMap<String,Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], 0);
        }

        for (int i = 0; i < recipes.length; i++) {
            for(String dep : ingredients.get(i)){
                if(!sup.contains(dep)){
                    graph.putIfAbsent(dep, new ArrayList<>());
                    graph.get(dep).add(recipes[i]);
                    indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
                }
            }
        }
        Queue<String> bfs = new LinkedList<>();
        for(String key : indegree.keySet()){
            if(indegree.get(key) == 0){
                bfs.offer(key);
            }
        }
        List<String> res = new ArrayList<>();
        while (!bfs.isEmpty()){
            String curr = bfs.poll();
            res.add(curr);
            if(!graph.containsKey(curr)) continue;
            for(String dep : graph.get(curr)){
                indegree.put(dep, indegree.get(dep) - 1);
                if(indegree.get(dep) == 0){
                    bfs.offer(dep);
                }
            }
        }
        return res;
    }

    HashMap<String,Boolean> visited = new HashMap<>();
    public boolean helper(String r, HashMap<String, Integer> indexMap,
                          List<List<String>> ingredients, HashSet<String> supplies){
        if(supplies.contains(r)) return true;
        if(visited.containsKey(r)) return visited.get(r);
        if(!indexMap.containsKey(r)) return false;
        visited.put(r, false);
        for(String ing : ingredients.get(indexMap.get(r))){
            if(supplies.contains(ing)){
                continue;
            }
            boolean status = helper(ing, indexMap, ingredients, supplies);
            visited.put(ing, status);
            if(!status) return false;
        }
        visited.put(r, true);
        return true;
    }
}
