class Solution {
    public int shareCandies(int[] candies, int k) {
        if(k == 0){
            return (int)Arrays.stream(candies).distinct().count();
        }
        int  n = candies.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(candies[i], freqMap.getOrDefault(candies[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int candy = candies[i];
            freqMap.put(candy, freqMap.get(candy) - 1);
            if(freqMap.get(candy) == 0) freqMap.remove(candy);
            if(i >= k){
                int prevCandy = candies[i - k];
                freqMap.put(prevCandy, freqMap.getOrDefault(prevCandy, 0) + 1);
            }
            if(i >= k-1){
                ans = Math.max(ans, freqMap.size());
            }
        }
        return ans;
    }
}