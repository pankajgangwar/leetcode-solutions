/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        int max = -1;
        Node root = null;
        for(Node n : tree){
            int count = getRoot(n);
            if(count > max){
                root = n;
                max = count;
            }
        }
        return root;
    }
    HashMap<Node, Integer> cache = new HashMap<>();
    public int getRoot(Node root){
        if(cache.containsKey(root)) return cache.get(root);
        int count = root.children.size();
        for(Node n : root.children){
            count += getRoot(n);
        }
        cache.put(root, count);
        return count;
    }
}