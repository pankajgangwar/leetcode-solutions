/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
        //return dfs(grid);
    }
    
    public Node helper(int[][] grid, int x, int y, int len){
        if(len == 1){
            return new Node(grid[x][y] != 0, true, null,null,null,null);
        }
        Node root = new Node(true, false);
        Node topLeft = helper(grid, x, y, len / 2);
        Node topRight = helper(grid, x, y + len / 2, len / 2);
        Node bottomLeft = helper(grid, x + len / 2, y, len / 2);
        Node bottomRight = helper(grid, x + len / 2, y + len / 2, len / 2);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val){
            root.val = topLeft.val;
            root.isLeaf = true;
        }else{
            root.topLeft = topLeft;
            root.bottomLeft = bottomLeft;
            root.topRight = topRight;
            root.bottomRight = bottomRight;
        }
        return root;

    }

    private Node dfs(int[][] grid) {
       int n = grid.length;
        int start = grid[0][0];
        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(start != grid[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            //If all values in this grid are same
            Node root = new Node(start == 1, true, null, null, null, null );
            return root;
        }else{
            //break into 4 sub-square
            //bottom-left
            Node root = new Node(true, false);
            int half = n / 2;
            int[][] topLeft = new int[n / 2 ][n / 2];
            int[][] topRight = new int[n / 2 ][n / 2];
            int[][] bottomLeft = new int[n / 2 ][n / 2];
            int[][] bottomRight = new int[n / 2 ][n / 2];
            for (int k = 0; k < n / 2; k++) {
                for (int l = 0; l < n / 2; l++) {
                    topLeft[k][l] = grid[k][l];
                }
            }
            root.topLeft = dfs(topLeft);

            for (int m = 0; m < n / 2; m++) {
                for (int l = n / 2; l < n ; l++) {
                    topRight[m][l % half] = grid[m][l];
                }
            }
            root.topRight = dfs(topRight);

            for (int k = n / 2; k < n; k++) {
                for (int m = 0; m < n / 2 ; m++) {
                    bottomLeft[k % half][m % half] = grid[k][m];
                }
            }
            root.bottomLeft = dfs(bottomLeft);

            for (int p = n / 2; p < n; p++) {
                for (int m = n / 2; m < n ; m++) {
                    bottomRight[p % half][m % half] = grid[p][m];
                }
            }
            root.bottomRight = dfs(bottomRight);
            return root;
        }
        
    }
}