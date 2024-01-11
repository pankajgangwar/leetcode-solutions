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
    public int longestZigZag(TreeNode root) {
        helper(root, true);
        return globalMax;
    }
    
    int globalMax = 0;
    public int helper(TreeNode root, boolean isRight){
        if(root == null){
            return 0;
        }
        int l = helper(root.left, true);
        int r = helper(root.right, false);

        globalMax = Math.max(globalMax, l);
        globalMax = Math.max(globalMax, r);

        return 1 + (isRight ? r : l);
    }
}