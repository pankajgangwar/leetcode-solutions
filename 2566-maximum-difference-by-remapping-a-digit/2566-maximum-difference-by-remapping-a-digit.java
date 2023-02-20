class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        StringBuilder maxStr = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '9') {
                char d = s.charAt(i);
                for (int j = i; j < s.length(); j++) {
                    if(s.charAt(j) == d){
                        maxStr.setCharAt(j, '9');
                    }
                }
                break;
            }
        }
        StringBuilder minStr = new StringBuilder(s);
        char digit = minStr.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            if (minStr.charAt(i) == digit){
                minStr.setCharAt(i, '0');
            }
        }
        return Integer.parseInt(maxStr.toString()) - Integer.parseInt(minStr.toString());
    }
}