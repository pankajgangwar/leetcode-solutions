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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{//Node to be deleted has left or right child or none
            //If node has one child, copy the child to the node and delete 
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                //Node has both left and right child
                //Find minimum from right sub-tree and delete
                root.val = maxValue(root.left);
                
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    public int maxValue(TreeNode root){
        int max = root.val;
        while(root.right != null){
            max = root.right.val;
            root = root.right;
        }
        return max;
    }
    
    public int minValue(TreeNode root){
        int min = root.val;
        while(root.left != null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}