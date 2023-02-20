class Solution {
    
    public int getNumber(int n, int d_from, int d_to){
        List<Integer> digits = new ArrayList<>();
        while(n > 0){
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        int ret = 0;
        for(int d : digits){
            if(d == d_from){
                d = d_to;
            }
            ret = d + ret * 10;
        }
        return ret;
    }

    public int minMaxDifference(int num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int d1 = 0; d1 <= 9; d1++){
            for (int d2 = 0; d2 <= 9 ; d2++) {
                min = Math.min(min, getNumber(num, d1, d2));
                max = Math.max(max, getNumber(num, d1, d2));
            }
        }
        return max - min;
    }
    
    public int minMaxDifference1(int num) {
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