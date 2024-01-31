class Solution {
    public int minFlipsMonoIncr(String S) {
        char[] arr = S.toCharArray();
        int flipCount = 0;
        int oneCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0') {
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