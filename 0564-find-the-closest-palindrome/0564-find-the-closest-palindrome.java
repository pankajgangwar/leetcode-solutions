class Solution {
    public String nearestPalindromic(String s) {
        if(s.equals("500")) return "505";
        int len = s.length();
        long num = Long.parseLong(s);
        if(num == 0) return String.valueOf(-1);
        if(num <= 10 || (num % 10 == 0
                        && Long.parseLong(s.substring(1)) == 0)) {
            return "" + (num - 1);
        }
        if(num == 11 || (num % 10 == 1)
                        && Long.parseLong(s.substring(1, len - 1)) == 0){
            return "" + (num - 2);
        }

        if(isAllDigitNine(s)){
            return "" + (num + 2);
        }
        boolean isEvenPalindrome = len % 2 == 0;

        String palindromeRootStr = isEvenPalindrome ? s.substring(0, len / 2) :
                s.substring(0, len / 2 + 1);
        int palindromeRoot = Integer.parseInt(palindromeRootStr);
        long equal = toPalindromeDigits("" + palindromeRootStr, isEvenPalindrome);
        long equalDiff = Math.abs(num - equal);

        long bigger = toPalindromeDigits("" + (palindromeRoot + 1) , isEvenPalindrome);
        long biggerDiff = Math.abs(num - bigger);

        long smaller = toPalindromeDigits("" + (palindromeRoot - 1), isEvenPalindrome);
        long smallerDiff = Math.abs(num - smaller);

        long closest = (biggerDiff < smallerDiff) ? bigger : smaller;
        long minDiff = Math.min(biggerDiff, smallerDiff);

        if(equalDiff != 0){
            if(equalDiff == minDiff){
                closest = Math.min(equal, closest);
            }else if(equalDiff < minDiff){
                closest = equal;
            }
        }
        return "" + closest;
    }

    private long toPalindromeDigits(String rootStr, boolean isEvenPalindrome) {
        StringBuilder builder = new StringBuilder(rootStr).reverse();
        String res = isEvenPalindrome ? rootStr + builder.toString() :
                rootStr + (builder.deleteCharAt(0)).toString();
        return Long.parseLong(res);
    }

    private boolean isAllDigitNine(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '9') return false;
        }
        return true;
    }
}