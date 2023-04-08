/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    Node orgRoot;
    public Node flipBinaryTree(Node root, Node leaf) {
        orgRoot = root;
        return helper(leaf, null);
    }

    Node helper(Node node, Node newParent){
        Node oldParent = node.parent;
        node.parent = newParent;
        if(node.left == newParent) node.left = null;
        if(node.right == newParent) node.right = null;
        if(node == orgRoot) return node;
        if(node.left != null) node.right = node.left;
        node.left = helper(oldParent, node);
        return node;
    }
}