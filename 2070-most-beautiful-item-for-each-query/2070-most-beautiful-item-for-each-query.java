class Solution {
    
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            int price = items[i][0];
            int beauty = items[i][1];
            maxBeauty = Math.max(maxBeauty, beauty);
            map.put(price, maxBeauty);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length ; i++) {
            Integer beauty = map.floorKey(queries[i]);
            if(beauty != null){
                ans[i] = map.get(beauty);
            }
        }
        return ans;
    }
    
    public int[] maximumBeauty1(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i-1][1]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];
            ans[i] = getMaxBeauty(items, price);
        }
        return ans;
    }

    public int getMaxBeauty(int[][] items, int price){
        int low = 0, high = items.length - 1;
        int maxBeauty = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(items[mid][0] <= price){
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return maxBeauty;
    }
}