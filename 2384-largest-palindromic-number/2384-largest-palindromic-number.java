class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            freq[d]++;
        }
        int largestOdd = -1;
        String res = "";

        for (int i = 9; i >= 0; i--) {
            int fr = 0;
            if(freq[i] % 2 == 0){
                fr = freq[i];
            }else{
                fr = freq[i] - 1;
                if(largestOdd == -1){
                    largestOdd = i;
                }
            }
            if(fr > 0){
                if(res.isEmpty() && i == 0) continue;
                String mid = String.join("", Collections.nCopies(fr, String.valueOf(i)));
                res = res.substring(0, res.length() / 2) + mid + res.substring(res.length() / 2);
            }
        }
        if(largestOdd != -1){ // 9999
            res = res.substring(0, res.length() / 2) + largestOdd + res.substring(res.length() / 2);
        }else if(freq[0] > 0 && res.isEmpty()){
            res = "0";
        }
        return res;
    }
}