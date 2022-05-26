class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>(Arrays.asList(supplies));
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            indexMap.put(recipes[i], i);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            String r = recipes[i];
            if (helper(r, indexMap, ingredients, sup)) {
                res.add(r);
            }
        }
        return res;
    }

    HashMap<String, Boolean> visited = new HashMap<>();

    public boolean helper(String r, HashMap<String, Integer> indexMap, List<List<String>> ingredients, HashSet<String> supplies) {
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
