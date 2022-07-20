/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return res;

        res.add(root.val);
        addLeftView(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        addRightView(root.right);
        return res;
    }
    
    public void addLeftView(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        
        res.add(root.val);
        
        if(root.left != null)
            addLeftView(root.left);
        else if(root.right != null) 
            addLeftView(root.right);
    }
    
    public void addRightView(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right != null)
            addRightView(root.right);
        else if(root.left != null)
            addRightView(root.left);
        
        res.add(root.val);
    }

    public void addLeaves(TreeNode root){
        if(root == null ) return;
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        addLeaves(root.left);
        addLeaves(root.right);
    }
}