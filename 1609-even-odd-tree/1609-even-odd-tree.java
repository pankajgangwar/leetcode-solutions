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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        boolean even = true;
        while (!q.isEmpty()){
            int size = q.size();
            int prev = 0;
            if(even){
                prev = Integer.MIN_VALUE;
            }else{
                prev = Integer.MAX_VALUE;
            }
            while (size-- > 0 ){
                TreeNode curr = q.poll();
                int val = curr.val;
                if(even){
                    if(val % 2 == 0 || prev >= val){
                        return false;
                    }
                     prev = val;
                }else{
                    if(val % 2 != 0 || prev <= val){
                        return false;
                    }
                    prev = val;
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            even = !even;
        }
        return true;
    }
}