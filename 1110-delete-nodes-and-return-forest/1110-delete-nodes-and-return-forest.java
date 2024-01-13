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
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = new HashSet<Integer>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] arr) {
        for(int ele : arr){
            set.add(ele);
        }
        //res.add(root);
       //delNodesDFS(root, set, res);
        //if(!res.contains(root.val)){
        //    res.add(root);
        //}

        helper(root, true);
        return res;
    }
    
    public TreeNode helper(TreeNode root, boolean isRoot){
        if(root == null) return null;
        boolean deleted = set.contains(root.val);
        if(!deleted && isRoot)
            res.add(root);

        root.left = helper(root.left, deleted);
        root.right = helper(root.right, deleted);

        return deleted ? null : root;
    }

    public TreeNode delNodesDFS(TreeNode root, Set<Integer> set, List<TreeNode> res){
        if(root == null) return null;

        root.left = delNodesDFS(root.left, set , res);
        root.right = delNodesDFS(root.right, set , res);

        if(set.contains(root.val)){
            if(root.left != null) res.add(root.left);
            if(root.right != null) res.add(root.right);
            root = null;
        }
        
        return root;
    }
}