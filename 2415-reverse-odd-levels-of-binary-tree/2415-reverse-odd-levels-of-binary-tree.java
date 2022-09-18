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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        dfs(root.left, root.right, 1);
        return root;
    }

    public void dfs(TreeNode a , TreeNode b, int level){
        if(a == null || b == null) return;
        if(level % 2 != 0){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
        dfs(a.left, b.right, level + 1);
        dfs(a.right, b.left, level + 1);
    }

}