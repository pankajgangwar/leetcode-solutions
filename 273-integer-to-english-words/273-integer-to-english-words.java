class Solution {
        String[] LESS_THAN_20 = new String[]{"Zero","One","Two","Three",
                        "Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
                        "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] TENS = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty",
                        "Sixty","Seventy","Eighty","Ninety"};
        String[] THOUSANDS = new String[]{"","Thousand","Million","Billion"};
    
    public String numberToWords(int num) {
        
        String words = "";
        if(num == 0)
            return "Zero";
        
        int idx = 0;
        while(num > 0){
            if(num % 1000 != 0){
                words = helper(num % 1000) + THOUSANDS[idx] + " " + words;
            }
            num /= 1000;
            idx++;
        }
        return words.trim();
    }

    public String helper(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return LESS_THAN_20[num] + " ";
        else if(num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

}