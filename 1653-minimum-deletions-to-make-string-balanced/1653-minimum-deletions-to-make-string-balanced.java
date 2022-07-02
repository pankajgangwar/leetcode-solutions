class Solution {
    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();
        int flipCount = 0;
        int oneCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'a') {
                if(oneCount == 0) continue;
                flipCount++;
            }else {
                oneCount++;   
            }
            if(flipCount > oneCount) {
                flipCount = oneCount;
            }
        }
        return flipCount;
    }
}