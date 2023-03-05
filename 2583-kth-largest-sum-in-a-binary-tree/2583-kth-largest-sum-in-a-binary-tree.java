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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Queue<Long> maxQ = new PriorityQueue<Long>((a,b) -> -Long.compare(a,b));

        while (!q.isEmpty()){
            long size = q.size();
            long sum = 0;
            while (size-- > 0){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
                sum += curr.val;
            }
            maxQ.offer(sum);
        }
        while (--k > 0 && !maxQ.isEmpty()){
            maxQ.poll();
        }
        return !maxQ.isEmpty() ? maxQ.peek() : -1;
    }
}