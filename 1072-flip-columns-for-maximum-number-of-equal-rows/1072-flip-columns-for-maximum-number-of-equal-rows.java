class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean compliment = matrix[i][0] == 1;
            int number = 0;
            int n = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                int bit = matrix[i][j];
                if(compliment){
                    bit = matrix[i][j] ^ 1;
                }
                number += bit * (1 << (n - 1 - j));
            }
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            count = Math.max(count, e.getValue());
        }
        return count;
    }
}