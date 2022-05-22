class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if(n <= 2){
            return n - 1;
        }
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        for (int i = 0; i < n - 2; i++) {
            int[] a = stockPrices[i];
            int[] b = stockPrices[i + 1];
            int[] c = stockPrices[i + 2];
            if(!isOnSameStraightLine(a[0], a[1], b[0], b[1], c[0], c[1])){
                count += 1;
            }
        }
        if(count == 0) return 1;
        return count;
    }
     public boolean isOnSameStraightLine(int x1, int y1, int x2, int y2, int x3, int y3){
        int a = x1 * (y2 - y3) +  x2 * (y3 - y1) +  x3 * (y1 - y2);
        return a == 0;
    }
}