class Solution {
    public String minWindow(String s, String t) {
        int count = t.length();
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch - 'A']++;
        }
        
        int start = 0, end = 0;
        int len = s.length();
        int d = Integer.MAX_VALUE;
        int head=0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(freq[ch - 'A']-- > 0) {
                count--;
            }
            //freq[ch - 'A']--;
            
            while(count == 0){
                if( (i - start) < d){
                    d = i - start + 1;
                    head = start;
                }
                char startCh = s.charAt(start++);
                if(freq[startCh - 'A']++ == 0) {
                    count++;
                }
                //freq[startCh - 'A']++;
            }
        }
        return d==Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}