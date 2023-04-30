class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] loc = map.get(arr[i]);
            row[loc[0]]++;
            col[loc[1]]++;
            if(row[loc[0]] == mat[0].length || col[loc[1]] == mat.length){
                return i;
            }
        }
        return -1;
    }
}