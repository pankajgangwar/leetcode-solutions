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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       // System.out.println(Arrays.toString(nums));
        int n = nums.length;
        if(n == 0) return null;
        int max = Arrays.stream(nums).max().getAsInt();
        int maxI = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == max){
                maxI = i;
                break;
            }
        }
        TreeNode root = new TreeNode(nums[maxI]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxI));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxI + 1, nums.length));
        return root;
    }
}