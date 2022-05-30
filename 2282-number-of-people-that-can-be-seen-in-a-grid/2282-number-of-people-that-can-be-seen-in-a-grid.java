class Solution {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Stack<Integer> st = new Stack<>();
            for (int j = n - 1; j >= 0; --j) {
                int count = 0;
                int last = 0;
                while (!st.isEmpty() && st.peek() <= heights[i][j]){
                    ++count;
                    last = st.pop();
                }
                count += (!st.isEmpty() && last != heights[i][j]) ? 1 : 0;
                ans[i][j] += count;
                st.push(heights[i][j]);
            }
        }

        for (int col = 0; col < n; ++col) {
            Stack<Integer> st = new Stack<>();
            for (int row = m - 1; row >= 0; --row) {
                int count = 0;
                int last = 0;
                while (!st.isEmpty() && st.peek() <= heights[row][col]){
                    ++count;
                    last = st.pop();
                }
                count += (!st.isEmpty() && last != heights[row][col]) ? 1 : 0;
                ans[row][col] += count;
                st.push(heights[row][col]);
            }
        }
        return ans;
    }
}