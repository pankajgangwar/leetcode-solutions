class Solution {
    public int splitNum(int num) {
        String s = String.valueOf(num);
        int[] digit = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            digit[i] = s.charAt(i) - '0';
        }
        Arrays.sort(digit);
        StringBuilder even = new StringBuilder("0");
        StringBuilder odd = new StringBuilder("0");
        for(int i = 0; i < digit.length; i++){
            if(i % 2 == 0){
                even.append(digit[i]);
            }else{
                odd.append(digit[i]);
            }
        }
        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }
}