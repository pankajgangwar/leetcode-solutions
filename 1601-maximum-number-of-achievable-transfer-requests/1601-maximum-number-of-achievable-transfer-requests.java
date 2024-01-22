class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] count = new int[n];
        helper(0, 0, count, requests);
        return maxRequest;
    }
    int maxRequest = 0;
    public void helper(int index, int currReques, int[] count, int[][] request){
        if(index == request.length){
            for (int x : count) {
                if(x != 0){
                    return;
                }
            }
            maxRequest = Math.max(maxRequest, currReques);
            return;
        }
        int from = request[index][0];
        int to = request[index][1];
        
        count[from]++;
        count[to]--;
        helper(index + 1, currReques + 1, count, request);
        count[to]++;
        count[from]--;
        
        helper(index + 1, currReques, count, request);
    }
}