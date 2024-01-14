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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        while(root != null){
            List<Integer> list = new ArrayList<>();
            root = removeLeaves(root, list);
            res.add(list);
        }
        return res;
    }

    public TreeNode removeLeaves(TreeNode root, List<Integer> list){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return null;
        }
        root.left = removeLeaves(root.left, list);
        root.right = removeLeaves(root.right, list);

        return root;
    }
}