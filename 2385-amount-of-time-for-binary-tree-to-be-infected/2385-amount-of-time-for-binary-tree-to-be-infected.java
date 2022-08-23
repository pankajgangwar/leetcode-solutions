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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        inorder(root, null, map);
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        
        vis.add(start);
        q.offer(start);
        
        int mins = 0;
        
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int curr = q.poll();
                for(TreeNode adj : map.get(curr)){
                    if(vis.contains(adj.val)){
                        continue;
                    }
                    vis.add(adj.val);
                    q.offer(adj.val);
                }
            }
            mins += (q.isEmpty() ? 0 : 1);
        }
        return mins;
    }

    private void inorder(TreeNode root, TreeNode parent, HashMap<Integer, List<TreeNode>> map) {
        if(root == null) return;
        map.putIfAbsent(root.val, new ArrayList<>());
        if(parent != null){
            map.get(root.val).add(parent);
        }
        if(root.left != null){
            map.get(root.val).add(root.left);
        }
        if(root.right != null){
            map.get(root.val).add(root.right);
        }
        inorder(root.left, root, map);
        inorder(root.right, root, map);
    }
}