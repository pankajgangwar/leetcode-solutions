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
    public TreeNode constructUsingStack(int[] nums){
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]){
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructUsingStack(nums);
    }
    
    public TreeNode helper(int[] nums) {
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
        root.left = helper(Arrays.copyOfRange(nums, 0, maxI));
        root.right = helper(Arrays.copyOfRange(nums, maxI + 1, nums.length));
        return root;
    }
}