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
    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root) - 1;
        int rows = h + 1;
        int cols = (int)Math.pow(2, h+1) - 1;

        String[][] res = new String[rows][cols];
        dfs(root, res, 0, (cols - 1) / 2, h);

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < res[i].length; j++) {
                if(res[i][j] == null) res[i][j] = "";
                ans.get(i).add(res[i][j]);
            }
        }
        return ans;
    }

    // For each node that has been placed in the matrix at position res[r][c],
    // place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
    public void dfs(TreeNode root, String[][] arr, int r, int c, int h){
        if(root == null) return;
        arr[r][c] = String.valueOf(root.val);
        int var = (int)Math.pow(2, h - r - 1);
        dfs(root.left, arr, r + 1, c - var, h );
        dfs(root.right, arr, r + 1, c + var, h );
    }

    int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}