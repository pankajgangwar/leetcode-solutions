class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            left[i] = (ratings[i - 1] < ratings[i] ) ? left[i - 1] + 1 : left[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : right[i];
        }
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = Math.max(left[i], right[i]);
        }
        return Arrays.stream(candies).sum();
    }
}