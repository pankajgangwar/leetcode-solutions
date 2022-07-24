class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                row.append(grid[i][j]);
                row.append(",");
            }
            String s = row.toString();
            rowMap.put(s, rowMap.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                col.append(grid[j][i]);
                col.append(",");
            }
            String s = col.toString();
            if(rowMap.containsKey(s)){
                res += rowMap.get(s);
            }
        }
        return res;
    }
}