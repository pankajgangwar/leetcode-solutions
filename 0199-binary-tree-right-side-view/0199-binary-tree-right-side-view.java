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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
       // rightViewBFS(root);
        rightViewRec(root, result, 0);
        return result;
    }
    
    public void rightViewBFS(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> mQueue = new LinkedList<>();
        mQueue.offer(root);
        while (!mQueue.isEmpty()){
            int size = mQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = mQueue.poll();
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    mQueue.offer(curr.left);
                }
                if(curr.right != null){
                    mQueue.offer(curr.right);
                }
            }
        }
    }

    public void rightViewRec(TreeNode root, List<Integer> res, int height){
        if(root == null){
            return;
        }
        if(res.size() == height){
            res.add(root.val);
        }
        rightViewRec(root.right, res, height+1);
        rightViewRec(root.left, res, height+1);
    }
}