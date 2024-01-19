class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum  = 0;
        int n = cardPoints.length;
        
        for(int i = n - k; i < cardPoints.length; i++ ){
            sum += cardPoints[i];
        }
        if(k == n){
            return sum;
        }
        int end = n - k;
        int start = 0;
        int maxSum = sum;
        while(k-- > 0){
            sum = sum + cardPoints[start % n];
            
            start++;
            start = start % n;
            
            sum = sum - cardPoints[end % n];
            end++;
            end = end % n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}