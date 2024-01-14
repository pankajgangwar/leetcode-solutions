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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLca(root, p, q);
        return getDistance(lca, p) + getDistance(lca, q) - 2;
    }
    
    public int getDistance(TreeNode root, int n){
        if(root == null) return 0;
        if(root.val == n){
            return 1;
        }
        int left = getDistance(root.left, n);
        int right = getDistance(root.right, n);
        if(left >= 1){
            left += 1;
        }else if(right >= 1){
            right += 1;
        }
        return left + right;
        
    }
    
    public TreeNode findLca(TreeNode root, int p, int q){
        if(root == null) return root;
        if(root.val == p || root.val == q) return root;
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
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