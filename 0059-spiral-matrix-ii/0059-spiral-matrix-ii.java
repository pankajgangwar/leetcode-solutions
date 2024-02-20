class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int filled = 0;

        int left = 0; int right = n - 1;
        int up = 0;   int down = n -1;

        while (filled < n*n){
            for (int i = left; i <= right && filled < n*n ; i++) {
                matrix[up][i] = ++filled;
            }
            for (int i = up +1; i <= down -1 && filled < n*n ; i++) {
                matrix[i][right] = ++filled;
            }

            for (int i = right ; i >= left && filled < n*n ; i--) {
                matrix[down][i] = ++filled;
            }

            for (int i = down - 1 ; i >= up + 1 && filled < n*n ; i--) {
                matrix[i][left] = ++filled;
            }
            left++;right--;up++;down--;
        }
        return matrix;
    }
}