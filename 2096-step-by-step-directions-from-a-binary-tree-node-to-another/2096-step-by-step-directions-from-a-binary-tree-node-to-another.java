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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        dfs(lca, startValue, s);
        dfs(lca, destValue, d);
        
        return "U".repeat(s.length()) + d.reverse();
    }
    
    public boolean dfs(TreeNode root, int src, StringBuilder path){
        if(root.val == src) {
            return true;
        }
        if(root.left != null && dfs(root.left, src, path)){
            path.append("L");
        }else if(root.right != null && dfs(root.right, src, path)){
            path.append("R");
        }
        return path.length() > 0;
    }

    
    public TreeNode findLCA(TreeNode root, int p, int q) {
        if(root == null) return root;
        if(root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }

}