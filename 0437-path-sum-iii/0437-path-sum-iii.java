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
    
     public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0l, 1);
        return dfs(root, 0l, sum, prefixSum);
    }

    public int dfs(TreeNode root, long currSum, int targetSum, Map<Long, Integer> prefixSum){
        if(root == null) return 0;
        currSum += root.val;
        int res = prefixSum.getOrDefault(currSum - targetSum, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        res += dfs(root.left, currSum, targetSum, prefixSum)
                + dfs(root.right, currSum, targetSum, prefixSum);

        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return res;
    }
    
    public int pathSum1(TreeNode root, int sum) {
        if(root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int dfs(TreeNode root, int sum){
        if(root == null) return 0;
        int count = 0;
        if(sum - root.val == 0){
            count += 1;
        }
        int left = dfs(root.left, sum - root.val);
        int right = dfs(root.right, sum - root.val);
        return left + right + count;
    }
}