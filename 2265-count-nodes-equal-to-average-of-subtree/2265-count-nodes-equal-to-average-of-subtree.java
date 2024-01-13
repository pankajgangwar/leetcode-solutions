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
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }

    int count = 0;
    public int[] helper(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = left[0] + right[0] + 1; //num of nodes in subtree
        res[1] = left[1] + right[1] + root.val; // sum of nodes values

        int avg = res[1] / res[0];
        if(avg == root.val) {
            count += 1;
        }
        return res;
    }
}