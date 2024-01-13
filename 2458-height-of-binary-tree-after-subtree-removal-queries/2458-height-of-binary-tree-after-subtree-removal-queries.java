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
    
    //int max = 100001;
    int max = 10;
    int[] d1 = new int[max];
    int[] d2 = new int[max];
    int[]level = new int[max];
    int[]depth = new int[max];
    public int[] treeQueries1(TreeNode root, int[] queries) {
        height(root, 0);
        int totalQueries = queries.length;
        int[] ans = new int[totalQueries];
        System.out.println(Arrays.toString(d1) + "\n" + Arrays.toString(d2) + "\n" + Arrays.toString(depth) + " \n" + Arrays.toString(level));
        for (int i = 0; i < totalQueries; i++) {
            int q = queries[i];
            int l = level[q];
            ans[i] = l + (d1[l] == depth[q] ? d2[l] : d1[l]) - 1;
        }
        return ans;
    }

    public int height(TreeNode curr, int l){
        if(curr == null) return 0;
        level[curr.val] = l;
        int h = 1 + Math.max(height(curr.left, l + 1),
                height(curr.right, l + 1));
        depth[curr.val] = h;
        if(d1[l] < depth[curr.val]){
            d2[l] = d1[l];
            d1[l] = depth[curr.val];
        }else if(d2[l] < depth[curr.val]){
            d2[l] = depth[curr.val];
        }
        return depth[curr.val];
    }
    
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
        int h = 1 + Math.max(height(curr.left, map), height(curr.right, map));
        map.put(curr.val, h);
        return h;
    }
}