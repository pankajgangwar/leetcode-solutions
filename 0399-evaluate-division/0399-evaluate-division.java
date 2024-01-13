class Solution {
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
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