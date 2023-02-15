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
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer, Integer> heightMap = new HashMap<>();
        height(root, heightMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<Integer, PriorityQueue<int[]>> levelMap = new HashMap<>();
        HashMap<Integer, Integer> nodeLvl = new HashMap<>();
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            levelMap.putIfAbsent(level, new PriorityQueue<>((a, b) -> -a[1] + b[1]));
            while (size-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                levelMap.get(level).offer(
                        new int[]{curr.val,
                        heightMap.getOrDefault(curr.val, 0)});
                nodeLvl.put(curr.val, level);
            }
            level++;
        }

        int totalQueries = queries.length;
        int[] ans = new int[totalQueries];
        for (int i = 0; i < totalQueries; i++) {
            int q = queries[i];
            int qLevel = nodeLvl.getOrDefault(q, 0);
            PriorityQueue<int[]> list = levelMap.getOrDefault(qLevel, new PriorityQueue<>());
            if(!list.isEmpty() && list.peek()[0] != q){
                ans[i] = qLevel + list.peek()[1];
            }else if(list.size() > 1){
                int[] top = list.poll();
                ans[i] = qLevel + list.peek()[1];
                list.offer(top);
            }else{
                ans[i] = qLevel - 1;
            }
        }
        return ans;
    }
    
    public int height(TreeNode curr, HashMap<Integer, Integer> map){
        if(curr == null) return 0;
        if(curr.left == null && curr.right == null){
            return 0;
        }
        int h = Math.max(height(curr.left, map), height(curr.right, map));
        map.put(curr.val, h + 1);
        //System.out.println("Height from bottom " + curr.val + " is " + h);
        return h + 1;
    }
}