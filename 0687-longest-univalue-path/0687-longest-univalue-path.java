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
    public int longestUnivaluePath(TreeNode root) {
        getSubTreeUnivalue(root);
        return maxUniValLength;
    }

    int maxUniValLength = 0;
    public int getSubTreeUnivalue(TreeNode root){
        if(root == null) return 0;
        int left = getSubTreeUnivalue(root.left);
        int right = getSubTreeUnivalue(root.right);
        
        int leftArrow = 0;
        int rightArrow = 0;
        if(root.left != null && root.val == root.left.val){
            leftArrow = left + 1;
        }
        
        if(root.right != null && root.val == root.right.val){
            rightArrow = right + 1;
        }
        maxUniValLength = Math.max(maxUniValLength, leftArrow + rightArrow);
        return Math.max(leftArrow, rightArrow);
    }
}