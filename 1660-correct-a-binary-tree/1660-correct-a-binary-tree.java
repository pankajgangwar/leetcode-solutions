/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();// child, parent
    public TreeNode correctBinaryTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        if(root.right != null){
            if(map.containsKey(root.right.val)){
                root.right = null;
                return null;
            }
            map.put(root.right.val, root.val);
            root.right = helper(root.right);
        }
        if(root.left != null){
            map.put(root.left.val, root.val);
            root.left = helper(root.left);
        }
        return root;
    }
}