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
    public int rob(TreeNode root) {
        //robRec(root);
        //return robMemo(root, new HashMap<TreeNode,Integer>());
        int[] res = robDP(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robDP(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left = robDP(root.left);
        int[] right = robDP(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0] , left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public int robMemo(TreeNode root, Map<TreeNode,Integer> map){
        if(root == null) return 0;
        int val = 0;

        if(map.containsKey(root)){
            return map.get(root);
        }

        if(root.left != null){
            val+= robMemo(root.left.left, map) + robMemo(root.left.right, map);
        }
        if(root.right != null){
            val+= robMemo(root.right.left, map) + robMemo(root.right.right, map);
        }

        val = Math.max(root.val + val , robMemo(root.left, map) + robMemo(root.right, map));

        map.put(root, val);

        return val;
    }

    public int robRec(TreeNode root){
        if(root == null) return 0;
        int val = 0;
        if(root.left != null){
            val+= robRec(root.left.left) + robRec(root.left.right);
        }
        if(root.right != null){
            val+= robRec(root.right.left) + robRec(root.right.right);
        }

        return Math.max(root.val + val , robRec(root.left) + robRec(root.right));
    }
}