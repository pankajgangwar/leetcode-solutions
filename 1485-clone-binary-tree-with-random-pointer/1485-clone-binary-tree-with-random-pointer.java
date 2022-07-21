/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node, NodeCopy> visited = new HashMap<Node, NodeCopy>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;
        
        if(visited.containsKey(root)) return visited.get(root);
        
        NodeCopy cp = new NodeCopy(root.val, null, null, null);
        
        visited.put(root, cp);
        
        cp.left = copyRandomBinaryTree(root.left);
        cp.right = copyRandomBinaryTree(root.right);
        
        cp.random = copyRandomBinaryTree(root.random);
        
        return cp;
    }
}