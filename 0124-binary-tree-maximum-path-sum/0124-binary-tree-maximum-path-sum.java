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
    public int maxPathSum(TreeNode root) {
        maxPathSumRec(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSumRec(TreeNode root){
        if (root == null) {
            return 0;
        }
        int lSum = maxPathSumRec(root.left);
        int rSum = maxPathSumRec(root.right);

        int currMax = Math.max(Math.max(lSum + root.val, rSum + root.val ), root.val);
        
        maxSum = Math.max(maxSum, Math.max( currMax , rSum + lSum + root.val));
        return currMax;
    }
}