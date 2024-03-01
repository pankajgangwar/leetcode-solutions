class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int countOfOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') countOfOnes++;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if(countOfOnes-- > 1){
                arr[i] = '1';
            }else{
                arr[i] = '0';
            }
        }
        arr[arr.length - 1] = '1';
        return new String(arr);
    }
}