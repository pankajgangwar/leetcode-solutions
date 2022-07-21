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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneTree(Node root) {
        if(root == null) return root;
        //if(map.containsKey(root)) return map.get(root);
        
        ArrayList<Node> children = new ArrayList<>();
        Node copy = new Node(root.val, children);
        //map.put(root, copy);
        
        for(int i = 0; i < root.children.size(); i++){
            children.add(cloneTree(root.children.get(i)));
        }
        return copy;
    }
    
}