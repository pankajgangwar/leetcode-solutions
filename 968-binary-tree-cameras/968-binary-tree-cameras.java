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
    public int minCameraCover(TreeNode root) {
          Status s = installCamera(root);
        if(s.state == State.NOT_MONITORED){
            s.cameras++;
        }
        return s.cameras;
    }
    
    public Status installCamera(TreeNode root){
        if(root == null) return new Status(0, State.MONITORED);
        Status left = installCamera(root.left);
        Status right = installCamera(root.right);
        Status curr = new Status(left.cameras + right.cameras, State.NOT_MONITORED);
        if(left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED){
            curr.cameras++;
            curr.state = State.CAMERA;
        }else if(left.state == State.CAMERA || right.state == State.CAMERA){
            curr.state = State.MONITORED;
        }
        return curr;
    }
    
    enum State {
        MONITORED, NOT_MONITORED, CAMERA
    }
    
    class Status {
        int cameras;
        State state;
        public Status(int cameras, State state){
            this.cameras = cameras;
            this.state = state;
        }
    }
}