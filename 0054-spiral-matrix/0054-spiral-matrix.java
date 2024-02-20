class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return res;

        int n = matrix.length; int m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;

        while (res.size() < n*m){
            for (int i = left; i <= right && res.size() < n*m; i++)
                res.add(matrix[up][i]);

            for (int i = up + 1; i <= down - 1 && res.size() < n*m; i++)
                res.add(matrix[i][right]);

            for (int i = right; i >= left && res.size() < n*m; i--)
                res.add(matrix[down][i]);

            for (int i = down - 1; i >= up + 1 && res.size() < n*m; i--)
                res.add(matrix[i][left]);

            left++;right--;up++;down--;
        }
        return res;
    }
}